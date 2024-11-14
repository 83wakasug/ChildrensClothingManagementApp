package com.ChildrensClothingManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clothing_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clothing_type_id;

    private String clothing_Type;

    @OneToMany(mappedBy = "clothing_type")
    private List<Clothes> clothes;



}
