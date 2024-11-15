package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Clothing_Type;
import com.ChildrensClothingManagement.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Size_Repository extends JpaRepository<Size,Long> {



}
