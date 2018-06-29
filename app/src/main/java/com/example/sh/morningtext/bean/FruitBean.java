package com.example.sh.morningtext.bean;

public class FruitBean {
    public String fruitName;
    public String fruitAddress;
    public String fruitMoney;

    public String getFruitName() {
        return fruitName == null ? "" : fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitAddress() {
        return fruitAddress == null ? "" : fruitAddress;
    }

    public void setFruitAddress(String fruitAddress) {
        this.fruitAddress = fruitAddress;
    }

    public String getFruitMoney() {
        return fruitMoney == null ? "" : fruitMoney;
    }

    public void setFruitMoney(String fruitMoney) {
        this.fruitMoney = fruitMoney;
    }
}
