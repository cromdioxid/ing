package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query ("SELECT result FROM Product result WHERE result.barCode =:barCodeValue")
    public List<Product> findByBarCode(@Param("barCodeValue") String barCodeValue);
}
