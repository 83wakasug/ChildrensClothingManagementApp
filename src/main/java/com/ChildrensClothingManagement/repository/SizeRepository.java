package com.ChildrensClothingManagement.repository;

import com.ChildrensClothingManagement.entity.Size;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size,Long> {


}
