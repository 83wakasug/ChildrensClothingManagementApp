package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Clothing_Type;
import com.ChildrensClothingManagement.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Gender_Repository extends JpaRepository<Gender,Long> {



}
