package com.example.demo;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {

	public static final String COCA_COLA = "coca cola";
	public static final long BAR_CODE = 5942321000046L;
	public static final String FANTA = "Fanta";
	@Autowired
	private ProductController productController;

	@Autowired
	private ProductsService service;

//	@BeforeTestClass
//	void setUp() {
//		Product product = new Product(COCA_COLA, 10, BAR_CODE);
//		service.addNewProduct(product);
//	}

	@Test
	void contextLoads() {
		assertThat(productController).isNotNull();
	}

	@Test
	@Order(1)
	void testAddProduct() {
		Product product = new Product(COCA_COLA, 10, BAR_CODE);
		Product result = service.addNewProduct(product);
		assertTrue(result.getBarCode() == BAR_CODE);
	}

	@Test
	@Order(2)
	void testGetProducts() throws Exception {
		List<Product> result = service.getProducts();
		assertTrue(result.size() == 1);
	}

	@Test
	@Order(3)
	void testGetProduct() {
		Product result = service.getProduct(BAR_CODE);
		assertTrue(result.getName().equals(COCA_COLA));
	}

	@Test
	@Order(4)
	void testEditProduct() {
		Product newProduct = new Product(FANTA, 15, BAR_CODE);
		Product result = service.editProduct(newProduct);
		assertTrue(result.getName().equals(DemoApplicationTests.FANTA));
	}

	@Test
	@Order(5)
	void testChangePrice() {
		Product result = service.changePrice(BAR_CODE, 20);
		assertTrue(result.getPrice() == 20);
	}

	@Test
	@Order(6)
	void testDeleteProduct() {
		Product result = service.deleteProduct(BAR_CODE);
		assertTrue(result.getName().equals(FANTA));
		assertTrue(service.getProducts().isEmpty());
	}
}
