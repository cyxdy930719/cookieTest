package com.neuedu.pojo;

public class Product {
    private int product_id;
    private String product_name;
    private double price;
    private String product_des;
    private String url;

    public Product() {
    }

    public Product(int product_id, String product_name, double price, String product_des, String url) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.product_des = product_des;
        this.url = url;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_des() {
        return product_des;
    }

    public void setProduct_des(String product_des) {
        this.product_des = product_des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", product_des='" + product_des + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
