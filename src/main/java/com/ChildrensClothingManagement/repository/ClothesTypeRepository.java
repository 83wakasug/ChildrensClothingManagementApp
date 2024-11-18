package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.ClothingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesTypeRepository extends JpaRepository<ClothingType,Long> {



}
