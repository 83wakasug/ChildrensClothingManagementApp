package com.ChildrensClothingManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class Config {
    private String URL="http://localhost:8081/ChildrenClothing/";
    @Bean
    public RestClient restClient(){

            return RestClient.builder().baseUrl(URL).build();
    }


    }



}
