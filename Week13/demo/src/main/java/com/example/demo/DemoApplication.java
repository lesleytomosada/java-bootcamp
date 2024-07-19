package com.example.demo;

import com.example.demo.config.DataSourceConfig;
import com.example.demo.config.DataSourceProperties;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
    @Autowired
    private DataSourceConfig dataSourceConfig;

	Scanner scanner = new Scanner(System.in);
    @Autowired
    private DataSourceProperties dataSourceProperties;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enter a category ID to view its products.");
		List<Category> categoryList = categoryRepository.getAllCategories();
		categoryList.forEach(System.out::println);
		int categoryId = scanner.nextInt();
		scanner.nextLine();

		List<Product> productsByCategory = productRepository.getAllProductsByCategoryId(categoryId);
		productsByCategory.forEach(System.out::println);

//		Optional<Category> category = categoryRepository.getCategoryById(1);
//		System.out.println(category);

//		List<Product> productList = productRepository.getAllProducts();
//		productList.forEach(System.out::println);
	}
}
