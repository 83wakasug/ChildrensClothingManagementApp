package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Brand;
import com.ChildrensClothingManagement.entity.Clothing_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Brand_Repository extends JpaRepository<Brand,Long> {



}
