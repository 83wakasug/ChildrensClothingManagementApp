package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRespository extends JpaRepository<Clothes,Long> {





}
