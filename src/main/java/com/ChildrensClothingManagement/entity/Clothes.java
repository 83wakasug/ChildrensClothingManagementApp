package com.ChildrensClothingManagement.entity;

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
    private int size;
    private String brand;
    private String gender;
    private String color;


    @ManyToOne
    @JoinColumn(name = "clothing_type_id")
    private Clothing_Type clothing_type;
}
