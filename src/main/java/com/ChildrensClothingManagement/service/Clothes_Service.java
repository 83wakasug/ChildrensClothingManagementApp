package com.ChildrensClothingManagement.service;


import com.ChildrensClothingManagement.DTO.ClothesDTO;
import com.ChildrensClothingManagement.entity.Clothes;
import com.ChildrensClothingManagement.repository.ClothesRespository;

import com.github.dozermapper.core.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Clothes_Service {

    private final Mapper mapper;
    private final ClothesRespository clothesRepository;


    public List<ClothesDTO> findAll() {

        List<Clothes> listOfClothes = clothesRepository.findAll();
        if (listOfClothes.isEmpty()) return List.of();


        return listOfClothes.stream()
                .map(clothes -> {
                    ClothesDTO dto = new ClothesDTO();
                    dto.setId(clothes.getId());
                    dto.setQuantity(clothes.getQuantity());
                    dto.setSize(clothes.getSize().getSizeName());  // Sizeからサイズ名を取得
                    dto.setBrand(clothes.getBrand().getName());  // Brandからブランド名を取得
                    dto.setGender(clothes.getGender().getGenderName());  // Genderから性別名を取得
                    dto.setColor(clothes.getColor().getColorName());  // Colorから色名を取得
                    dto.setClothing_type(clothes.getClothingType().getClothingType());  // ClothingTypeから衣類タイプを取得
                    return dto;
                })
                .collect(Collectors.toList());
    }


    public List<Map<String, Object>> getClothingTypeAndSizeQuantities() {
        List<Object[]> results = clothesRepository.findClothingTypeAndSizeQuantities();

        // 結果を整形して返す例
        return results.stream().map(row -> {
            Map<String, Object> map = new HashMap<>();
            map.put("ClothingType", row[0]);
            map.put("Size", row[1]);
            map.put("TotalQuantity", row[2]);
            return map;
        }).collect(Collectors.toList());
    }


}
