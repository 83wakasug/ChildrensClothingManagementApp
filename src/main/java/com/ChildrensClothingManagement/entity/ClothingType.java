package com.ChildrensClothingManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClothingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clothing_type_id;

    private String clothingType;

    @OneToMany(mappedBy = "clothingType")
    private List<Clothes> clothes;



}
