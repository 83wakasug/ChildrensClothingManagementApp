package com.ChildrensClothingManagement.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClothesDTO {

    private Long id;
    private int quantity;
    private String size;
    private String brand;
    private String gender;
    private String color;
    private String clothing_type;

}
