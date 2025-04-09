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

   public String getName() {
       return this.productName;
   }

   public long getBarCode() {
       return this.barCode;
   }

   public long getPrice() {
       return price;
   }

   @Override
    public String toString() {
       return this.productName;
   }

}
