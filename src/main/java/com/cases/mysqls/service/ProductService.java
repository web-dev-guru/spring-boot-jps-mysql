package com.cases.mysqls.service;

import com.cases.mysqls.bean.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();
    public Product saveOrUpdate(Product product);
    public List<String> findByStr(String desc);

}
