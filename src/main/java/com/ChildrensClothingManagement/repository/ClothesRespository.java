package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRespository extends JpaRepository<Clothes,Long> {
    @Query(value = """
    SELECT
    clothing_type.clothing_type,
    size.size_name AS size,
    SUM(Clothes.quantity) AS TotalQuantity
    FROM
            clothes
    JOIN
    clothing_type ON clothes.clothing_type_id = clothing_type.clothing_type_id
            JOIN
    Size ON clothes.size_id = size.id
    GROUP BY
    clothing_type.clothing_type, size.size_Name
    ORDER BY
    clothing_type.clothing_type, size.size_Name;
  """, nativeQuery = true)

    List<Object[]> findClothingTypeAndSizeQuantities();
}
