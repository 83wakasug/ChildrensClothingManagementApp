package com.ChildrensClothingManagement.service;


import com.ChildrensClothingManagement.DTO.ClothesDTO;
import com.ChildrensClothingManagement.entity.Clothes;
import com.ChildrensClothingManagement.entity.Size;
import com.ChildrensClothingManagement.repository.ClothesRespository;

import com.ChildrensClothingManagement.repository.SizeRepository;
import com.github.dozermapper.core.Mapper;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Clothes_Service {


    private final SizeRepository sizeRepository;
    private final EntityManager entityManager;



    // 動的SQLクエリを生成
    public String generateDynamicPivotQuery() {
        // 全てのサイズを取得



        List<Integer> sizes=getAllSizes();


        // サイズごとのCASE文を生成
        StringBuilder caseStatements = new StringBuilder();
        for (Integer size : sizes) {
            caseStatements.append(String.format(
                    "SUM(CASE WHEN size.size_name = '%d' THEN clothes.quantity ELSE 0 END) AS \"%d\", ",
                    size, size));
        }

        // 最後のカンマを削除
        caseStatements.setLength(caseStatements.length() - 2);

        // 動的SQLクエリを作成
        String query = String.format(
                "SELECT clothing_type.clothing_type, %s " +
                        "FROM clothing_type " +
                        "LEFT JOIN clothes ON clothes.clothing_type_id = clothing_type.clothing_type_id " +
                        "LEFT JOIN size ON clothes.size_id = size.id " +
                        "GROUP BY clothing_type.clothing_type " +
                        "ORDER BY clothing_type.clothing_type",
                caseStatements.toString());

        return query;
    }

    // クエリを実行してピボットリストを取得
    public List<Map<String, Object>> getPivotedClothingTypeData() {
        String query = generateDynamicPivotQuery();

        // クエリを実行
        Query nativeQuery = entityManager.createNativeQuery(query);

        // 結果をMap形式で取得
        List<Object[]> result = nativeQuery.getResultList();
        List<Map<String, Object>> pivotedData = new ArrayList<>();

        // 結果をMapに変換
        List<Integer> sizes = getAllSizes(); // サイズリストを取得
        for (Object[] row : result) {
            Map<String, Object> rowMap = new HashMap<>();
            rowMap.put("ClothingType", row[0]);
            for (int i = 0; i < sizes.size(); i++) {
                rowMap.put("Size_" + sizes.get(i), row[i + 1]);
            }
            pivotedData.add(rowMap);
        }

        return pivotedData;
    }
    public List<Integer> getAllSizes() {
        // Sizeエンティティのリストを取得
        List<Size> sizes = sizeRepository.findAll();

        // Sizeエンティティからサイズフィールド（例: sizeId）だけを抽出してList<Integer>に変換
        return sizes.stream()
                .map(Size::getSizeName) // getSizeId はエンティティ内のサイズを返すメソッド
                .collect(Collectors.toList());
    }
}
