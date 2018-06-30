package com.cases.mysqls.service;

import com.cases.mysqls.bean.Product;
import com.cases.mysqls.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdcuctServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll(); //fun with Java 8
        return products;
    }

    @Override
    public List<String> findByStr(String desc) {
        List<String> url=productRepository.findByStr(desc);
        return url;
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public String updateStrByStr(String url) {
       productRepository.updateStrByStr(url);
        return "update successfully";
    }
}
