package com.neuedu.service;


import com.neuedu.dao.IProductDao;
import com.neuedu.dao.ProductDaoImpl;
import com.neuedu.pojo.Product;
import com.neuedu.pojo.ResultData;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductDao dao = new ProductDaoImpl();

    @Override
    public List<Product> getLists() {
        return dao.getLists();
    }

    @Override
    public int add(Product product) {
        return dao.add(product);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public int update(Product product) {
        return dao.update(product);
    }

    @Override
    public List<Product> getresult(String text) {
        return dao.getresult(text);
    }

    @Override
    public ResultData getlists(int pageNo, int pageSize) {
        ResultData data = new ResultData(pageNo,pageSize,dao.getcount() );
        data.setLists(dao.getlists(pageNo,pageSize));
        return data;
    }

    @Override
    public int getCount() {
        return dao.getcount();
    }
}
