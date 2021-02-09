package com.example.demo.Model;

public class Product {
    private long productid;
    private String name;
    private double price;

    public Product(long productid, String name, double price) {
        this.productid = productid;
        this.name = name;
        this.price = price;
    }

    public Product(){

    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
