package com.example.sh.morningtext.bean;

public class Person {
    String address;
    String custName;
    String id;

    public String getAddress() {
        return address == null ? "" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustName() {
        return custName == null ? "" : custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
