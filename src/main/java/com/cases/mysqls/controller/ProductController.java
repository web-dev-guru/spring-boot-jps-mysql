package com.cases.mysqls.controller;

import com.cases.mysqls.bean.OrderHeader;
import com.cases.mysqls.bean.OrderLine;
import com.cases.mysqls.bean.Product;
import com.cases.mysqls.service.OrderService;
import com.cases.mysqls.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;





    @GetMapping(value="/new/product/{desc}")
    public String newProduct(@PathVariable  String desc){
        Product product= new Product();
        product.setDescription(desc);
        product.setImageUrl("tempurl");
        product.setPrice(new BigDecimal(100));
        productService.saveOrUpdate(product);
        return "OK1";
    }


    @GetMapping(value="/find/product/by/{desc}")
    public String dispProductUrl(@PathVariable  String desc){
        List<String> result=productService.findByStr("abc");
        result.forEach(n->System.out.println(n));
        return "bb";
    }

    @GetMapping(value="/call/{desc}")
    public String callRemote(@PathVariable  String desc){
        String url ="http://localhost:8080/find/product/by/"+desc;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=restTemplate.getForEntity( url, String.class);
        return "ccc"+response.getBody();
    }
}
