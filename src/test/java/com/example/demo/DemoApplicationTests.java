package com.example.demo;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class DemoApplicationTests {

	public static final String COCA_COLA = "coca cola";
	public static final long BAR_CODE = 5942321000046L;
	public static final String FANTA = "Fanta";
	@Autowired
	private ProductController productController;

	@Autowired
	private ProductsService service;

	@BeforeTestClass
	void setUp() {
		Product product = new Product(COCA_COLA, 10, BAR_CODE);
		service.addNewProduct(product);
	}

	@Test
	void contextLoads() {
		assertThat(productController).isNotNull();
	}

	@Test
	void testGetProducts() throws Exception {
		List<Product> result = service.getProducts();
		assertThat(result.size() == 1);
	}

	@Test
	void testGetProduct() {
		Product result = service.getProduct(BAR_CODE);
		assertThat(result.getName().equals(COCA_COLA));
	}

	@Test
	void testEditProduct() {
		Product newProduct = new Product(FANTA, 15, BAR_CODE);
		Product result = service.editProduct(newProduct);
		assertThat(result.getName().equals(DemoApplicationTests.FANTA));
	}

	@Test
	void testChangePrice() {
		Product result = service.changePrice(BAR_CODE, 20);
		assertThat(result.getPrice() == 20);
	}

	@Test
	void deleteProduct() {
		Product result = service.deleteProduct(BAR_CODE);
		assertThat(result.getName().equals(COCA_COLA));
		assertThat(service.getProducts().isEmpty());
	}
}
