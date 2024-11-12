package com.ChildrensClothingManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Clothing_Type {

    @Id
    private int id;

    private String Clothing_Type;

    @OneToMany(mappedBy = "clothing_type")
    private List<Clothes> clothes;

}
