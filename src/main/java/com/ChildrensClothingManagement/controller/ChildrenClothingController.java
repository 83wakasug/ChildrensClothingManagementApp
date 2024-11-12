package com.ChildrensClothingManagement.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ChildrenClothing")
@RequiredArgsConstructor
public class ChildrenClothingController {

    @GetMapping("/index")
    public String index(){


        return "index";
    }




}
