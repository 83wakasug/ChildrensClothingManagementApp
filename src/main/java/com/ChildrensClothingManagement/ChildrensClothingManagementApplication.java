package com.ChildrensClothingManagement;

import com.ChildrensClothingManagement.entity.*;
import com.ChildrensClothingManagement.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ChildrensClothingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChildrensClothingManagementApplication.class, args);


	}

	@Bean
	public CommandLineRunner run(       ClothesRespository clothesRespository,
										ClothesTypeRepository clothingTypeRepository,
										BrandRepository brandRepository,
										SizeRepository sizeRepository,
										ColorRepository colorRepository,
										GenderRepository genderRepository) {
		return (args) -> {
			// 初期データを定義
			List<String> clothingTypeNames = Arrays.asList(
					"Vinterjacka", "Vinterbyxor", "Skaljacka", "Skalbyxor",
					"Regnjacka", "Regnbyxor", "Fodrad Regnbyxa", "Fodrad RegnJacka",
					"Tröjor", "T-shirt", "Lång Byxsor", "Kort Byxsor", "Leggins", "Pajama"
			);
			List<String> brandNames = Arrays.asList("Nike", "Adidas", "Puma", "Reebok");
			List<Integer> sizeNames = Arrays.asList(44,50,56 ,60,62,68,70,74,80,86,90,92,98,100,104,110,116,120,122,128,130,134,140,146,150,152,158,160,164,170);
			List<String> colorNames = Arrays.asList("Red", "Blue", "Green", "Black");
			List<String> genderNames = Arrays.asList("Male", "Female", "Unisex");

			// 各テーブルにデータを保存
			List<ClothingType> clothingTypes = new ArrayList<>();
			for (int i = 0; i < clothingTypeNames.size(); i++) {
				ClothingType type = ClothingType.builder()
						.clothing_type_id((long) (i + 1))
						.clothingType(clothingTypeNames.get(i))
						.build();
				clothingTypes.add(type);
				clothingTypeRepository.save(type);
			}

			List<Brand> brands = new ArrayList<>();
			for (String brandName : brandNames) {
				Brand brand = Brand.builder().name(brandName).build();
				brands.add(brand);
				brandRepository.save(brand);
			}

			List<Size> sizes = new ArrayList<>();
			for (int sizeName : sizeNames) {
				Size size = Size.builder().sizeName(sizeName).build();
				sizes.add(size);
				sizeRepository.save(size);
			}

			List<Color> colors = new ArrayList<>();
			for (String colorName : colorNames) {
				Color color = Color.builder().colorName(colorName).build();
				colors.add(color);
				colorRepository.save(color);
			}

			List<Gender> genders = new ArrayList<>();
			for (String genderName : genderNames) {
				Gender gender = Gender.builder().genderName(genderName).build();
				genders.add(gender);
				genderRepository.save(gender);
			}

			// `Clothes`エンティティを作成
			Clothes clothes1 = new Clothes();
			clothes1.setQuantity(10);
			clothes1.setSize(sizes.get(1)); // サイズ 32
			clothes1.setBrand(brands.get(0)); // ブランド Nike
			clothes1.setGender(genders.get(0)); // 性別 Male
			clothes1.setColor(colors.get(0)); // 色 Red
			clothes1.setClothingType(clothingTypes.get(1)); // Clothing_Type: Vinterbyxor
			clothesRespository.save(clothes1);

			Clothes clothes2 = new Clothes();
			clothes2.setQuantity(5);
			clothes2.setSize(sizes.get(1)); // サイズ 28
			clothes2.setBrand(brands.get(1)); // ブランド Adidas
			clothes2.setGender(genders.get(1)); // 性別 Female
			clothes2.setColor(colors.get(1)); // 色 Blue
			clothes2.setClothingType(clothingTypes.get(2)); // Clothing_Type: Skaljacka
			clothesRespository.save(clothes2);
		};
	}

}
