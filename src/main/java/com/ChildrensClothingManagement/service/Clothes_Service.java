package com.ChildrensClothingManagement.service;

import com.ChildrensClothingManagement.DTO.ClothesDTO;
import com.ChildrensClothingManagement.entity.Clothes;
import com.ChildrensClothingManagement.repository.ClothesRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Clothes_Service {

    private final ClothesRespository clothesRepository;


    public List<Clothes> findAll() {

        List<Clothes> ListOfClothes = clothesRepository.findAll();
        if (ListOfClothes.isEmpty()) return null;

        return ListOfClothes;
    }


}
