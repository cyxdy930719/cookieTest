package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getLists();
    public int add(Product product);
    public int delete(int id);
    public Product getOne(int id);
    public int update(Product product);
    public List<Product> getresult(String text);
    public List<Product> getlists(int pageNo,int pageSize);
    public int getcount();
}
