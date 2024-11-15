package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Clothing_Type;
import com.ChildrensClothingManagement.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Color_Repository extends JpaRepository<Color,Long> {



}
