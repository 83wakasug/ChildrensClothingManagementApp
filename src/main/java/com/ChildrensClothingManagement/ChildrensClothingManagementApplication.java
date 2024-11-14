package com.ChildrensClothingManagement;

import com.ChildrensClothingManagement.entity.Clothes;
import com.ChildrensClothingManagement.entity.Clothing_Type;
import com.ChildrensClothingManagement.repository.ClothesRespository;
import com.ChildrensClothingManagement.repository.Clothes_Type_Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChildrensClothingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChildrensClothingManagementApplication.class, args);


	}

	@Bean
	public CommandLineRunner run(ClothesRespository clothesRespository, Clothes_Type_Repository clothingTypeRepository) {
		return (args) -> {
			Clothing_Type clothingType = Clothing_Type.builder().clothing_type_id(1L).clothing_Type("T-shirt").build();  // Example type
			clothingTypeRepository.save(clothingType);
			// Create Clothes objects and set properties
			Clothes clothes1 = new Clothes();
			clothes1.setQuantity(10);
			clothes1.setSize(32);
			clothes1.setBrand("Nike");
			clothes1.setGender("Male");
			clothes1.setColor("Red");
			clothes1.setClothing_type(clothingType);

			Clothes clothes2 = new Clothes();
			clothes2.setQuantity(5);
			clothes2.setSize(28);
			clothes2.setBrand("Adidas");
			clothes2.setGender("Female");
			clothes2.setColor("Blue");
			clothes2.setClothing_type(clothingType);

			// Save to the repository

			// Add Clothes with sample data
			clothesRespository.save(clothes1);
			clothesRespository.save(clothes2);

			System.out.println("Initial data has been added.");
		};
	}

}
