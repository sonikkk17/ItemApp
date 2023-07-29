package com.cpan252.tekkenreborn;

import com.cpan252.tekkenreborn.model.Item;
import com.cpan252.tekkenreborn.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

/**
 * mvn spring-boot:run does following steps
 * 1. mvn clean
 * 2. mvn compile
 * 3. mvn package
 * 4. java -jar target/tekkenreborn-0.0.1-SNAPSHOT.jar
 * 5. deploys jar to embedded tomcat
 */
@SpringBootApplication
public class TekkenrebornApplication {

	/**
	 * This is the main method that starts the application
	 * Spring Application Context is created here
	 * You can configure your application properties using @param args
	 * 
	 * @param args
	 */
	public static void main(String[] args) { SpringApplication.run(TekkenrebornApplication.class, args);}


		@Bean
		public CommandLineRunner dataLoader(ItemRepository repository) {
			return args -> {
				repository.save(Item.builder()
						.name("T-Shirt")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1500.0)).build());

				repository.save(Item.builder()
						.name("Shoes")
						.brandFrom(Item.Brand.BALENCIAGA)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1300.0)).build());

				repository.save(Item.builder()
						.name("Heels")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(2100.0)).build());


				repository.save(Item.builder()
						.name("T-Shirt")
						.brandFrom(Item.Brand.BALENCIAGA)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(1450.0)).build());


				repository.save(Item.builder()
						.name("Pants")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1200.0)).build());

				repository.save(Item.builder()
						.name("Hat")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(1830.0)).build());

				repository.save(Item.builder()
						.name("Long-sleeve")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2023)
						.price(BigDecimal.valueOf(1490.0)).build());

				repository.save(Item.builder()
						.name("Bag")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2023)
						.price(BigDecimal.valueOf(2130.0)).build());

				repository.save(Item.builder()
						.name("T-Shirt")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(1050.0)).build());

				repository.save(Item.builder()
						.name("Gloves")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2023)
						.price(BigDecimal.valueOf(1050.0)).build());

				repository.save(Item.builder()
						.name("Boots")
						.brandFrom(Item.Brand.BALENCIAGA)
						.yearOfCreation(2023)
						.price(BigDecimal.valueOf(2300.0)).build());

				repository.save(Item.builder()
						.name("Dress")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1470.0)).build());

				repository.save(Item.builder()
						.name("T-Shirt")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(1850.0)).build());

				repository.save(Item.builder()
						.name("Bag")
						.brandFrom(Item.Brand.BALENCIAGA)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1650.0)).build());

				repository.save(Item.builder()
						.name("Pants")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2023)
						.price(BigDecimal.valueOf(1359.0)).build());

				repository.save(Item.builder()
						.name("Purse")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1235.0)).build());

				repository.save(Item.builder()
						.name("T-Shirt")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(1050.0)).build());

				repository.save(Item.builder()
						.name("Gloves")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2023)
						.price(BigDecimal.valueOf(1050.0)).build());

				repository.save(Item.builder()
						.name("Boots")
						.brandFrom(Item.Brand.BALENCIAGA)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(2140.0)).build());

				repository.save(Item.builder()
						.name("Heels")
						.brandFrom(Item.Brand.DIOR)
						.yearOfCreation(2021)
						.price(BigDecimal.valueOf(1089.0)).build());

				repository.save(Item.builder()
						.name("T-Shirt")
						.brandFrom(Item.Brand.STONE_ISLAND)
						.yearOfCreation(2022)
						.price(BigDecimal.valueOf(1050.0)).build());


			};

	}

}
