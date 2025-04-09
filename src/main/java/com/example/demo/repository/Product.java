package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
    @GeneratedValue
    @Id
    private Long id;

    String productName;
    long price;
    long barCode;

   public Product(String name, long price, long barCode) {
       this.productName = name;
       this.price = price;
       this.barCode = barCode;
   }

   public Product(){}

   public String getName() {
       return this.productName;
   }

   public void setName(String name) {
       this.productName = name;
   }

   public long getBarCode() {
       return this.barCode;
   }

   public void setBarCode(long barCode) {
       this.barCode = barCode;
   }

   public long getPrice() {
       return price;
   }

   public void setPrice(long price) {
       this.price = price;
   }

   public Long getId() {
       return this.id;
   }

   @Override
    public String toString() {
       return this.productName;
   }

}
