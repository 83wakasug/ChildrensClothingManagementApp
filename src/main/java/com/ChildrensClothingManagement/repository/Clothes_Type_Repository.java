package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Clothing_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Clothes_Type_Repository extends JpaRepository<Clothing_Type,Long> {



}
