package com.ChildrensClothingManagement.controller;


import com.ChildrensClothingManagement.DTO.ClothesDTO;
import com.ChildrensClothingManagement.constant.Url;
import com.ChildrensClothingManagement.constant.ViewName;
import com.ChildrensClothingManagement.entity.Clothes;
import com.ChildrensClothingManagement.service.Clothes_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ChildrenClothingController {
   private final Clothes_Service service;


    @GetMapping(Url.INDEX)
    public String index(Model model){
        try {
//
//            List<ClothesDTO> clothesList;
//            System.out.println(clothesList.size());
//            System.out.println(clothesList.get(1));
//            model.addAttribute("clothesList", clothesList);


            return ViewName.INDEX;
        }catch (Exception e){

            return tryCatch(e);

        }

    }

    @GetMapping("/index2")
    public String index2(Model model) {
        try {
            List< Map<String, Object>> clothesData = service.getPivotedClothingTypeData();

            System.out.println(clothesData.size());
            model.addAttribute("clothesData", clothesData);
            return "index";
        } catch (Exception e) {
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
