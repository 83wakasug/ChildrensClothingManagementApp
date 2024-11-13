package com.ChildrensClothingManagement.controller;


import com.ChildrensClothingManagement.DTO.ClothesDTO;
import com.ChildrensClothingManagement.service.Clothes_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/ChildrenClothing")
@RequiredArgsConstructor
public class ChildrenClothingController {
   private final Clothes_Service service;
    @GetMapping("/index")
    public String index(Model model){
        try {
            ResponseEntity<?> responseEntity =service.getAll();

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                ArrayList<ClothesDTO> allClothes = (ArrayList<ClothesDTO>) responseEntity.getBody();
                model.addAttribute("candy", candyList);
            } else {
                handleErrorResponse(model,responseEntity);
                return "error";
            }
            return "search";
        }catch (Exception e){

            return tryCatch(e);

        }


        return "index";
    }







}
