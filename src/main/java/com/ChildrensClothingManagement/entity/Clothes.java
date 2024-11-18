package com.ChildrensClothingManagement.entity;

import com.ChildrensClothingManagement.DTO.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "clothing_type_id")
    private ClothingType clothingType;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;
}
