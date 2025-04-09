package com.example.demo.model;

public class ChangePriceDTO {

    private long barCode;
    private long price;

    public ChangePriceDTO(long barCode, long newPrice) {
        this.barCode = barCode;
        this.price = newPrice;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public long getBarCode() {
        return this.barCode;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }
}
