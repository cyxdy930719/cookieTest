package com.neuedu.service;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getLists();
    public int add(Product product);
    public int delete(int id);
    public Product getOne(int id);
    public int update(Product product);
}
