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
            ResponseEntity<?> responseEntity =service.listAll();

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                ArrayList<ClothesDTO> allClothes = (ArrayList<ClothesDTO>) responseEntity.getBody();
                model.addAttribute("clothes",allClothes);


            } else {
                handleErrorResponse(model,responseEntity);
                return "error";
            }
            return "index";
        }catch (Exception e){

            return tryCatch(e);

        }

    }



    private void handleErrorResponse(Model model, ResponseEntity<?> responseEntity) {

        if (responseEntity.getStatusCode().is5xxServerError()) {
            model.addAttribute("message", "Server Error");
        } else if (responseEntity.getStatusCode().is4xxClientError()) {
            model.addAttribute("message", "Client Error");
        } else {
            model.addAttribute("message", "An unexpected error occurred. Try Again!");
        }
    }

    public String tryCatch(Exception e){
        System.out.println(e.getMessage());

        return "error";
    }

}
