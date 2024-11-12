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
    private Long id;
    private int quantity;
    private int size;

    @ManyToOne
    private Clothing_Type clothing_type;
}
