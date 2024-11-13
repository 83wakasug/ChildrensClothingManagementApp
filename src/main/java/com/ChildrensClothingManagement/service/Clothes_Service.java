package com.ChildrensClothingManagement.service;

import com.ChildrensClothingManagement.DTO.ClothesDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@AllArgsConstructor
public class Clothes_Service {
    private final RestClient restClient;


    public ResponseEntity<List> listAll() {
        return restClient.get()
                .uri("/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(List.class);
    }




}
