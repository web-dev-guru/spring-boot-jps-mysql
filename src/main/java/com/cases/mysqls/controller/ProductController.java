package com.cases.mysqls.controller;

import com.cases.mysqls.bean.OrderHeader;
import com.cases.mysqls.bean.OrderLine;
import com.cases.mysqls.bean.Product;
import com.cases.mysqls.service.OrderService;
import com.cases.mysqls.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value="/update/{url}/by")
    public String updateProductUrl(@PathVariable  String url){
        String result=productService.updateStrByStr(url);
        return "dd";
    }

    @DeleteMapping(value="/callhandler/delete")
    public void handleDeleteRestCall(){
       System.out.println("handle delete");
    }

    @PutMapping(value="/callhandler/put")
    public String handlePutExchangeRestCall(@RequestBody String user ){
        System.out.println("get into exchange handler");
        System.out.println(user);
        return "put";
    }

}
