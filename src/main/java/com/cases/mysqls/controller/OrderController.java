package com.cases.mysqls.controller;

import com.cases.mysqls.bean.OrderHeader;
import com.cases.mysqls.bean.OrderLine;
import com.cases.mysqls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value="/new/order/{location}")
    public String newOrder(@PathVariable String location){
        /*
        * every line will add header instance, if not, foreign key will be null
        * header will add list of line instance.
        * */
        OrderHeader h1= new OrderHeader();
        Date now = new Date();
        Random rand = new Random();
        int  orderNum = rand.nextInt(50) + 1;
        int  itemNum = rand.nextInt(300) + 1;
        int  amount = rand.nextInt(30) + 1;
        int  price  = rand.nextInt(100) + 1;
        h1.setCreationTime(now);
        h1.setLastUpdateDate(now);
        h1.setLocation(location);
        h1.setOrderNumber(String.valueOf(orderNum));

        OrderLine l1= new OrderLine();
        l1.setItemNumber(String.valueOf(itemNum));
        l1.setQuantity(amount);
        l1.setUnitPrice(new BigDecimal(price));
        l1.setOrderHeader(h1);
        OrderLine l2= new OrderLine();
        itemNum = rand.nextInt(300) + 1;
        amount = rand.nextInt(30) + 1;
        price  = rand.nextInt(100) + 1;
        l2.setItemNumber(String.valueOf(itemNum));
        l2.setQuantity(amount);
        l2.setUnitPrice(new BigDecimal(price));
        l2.setOrderHeader(h1);
        OrderLine l3= new OrderLine();
        itemNum = rand.nextInt(300) + 1;
        amount = rand.nextInt(30) + 1;
        price  = rand.nextInt(100) + 1;
        l3.setItemNumber(String.valueOf(itemNum));
        l3.setQuantity(amount);
        l3.setUnitPrice(new BigDecimal(price));
        l3.setOrderHeader(h1);
        OrderLine l4= new OrderLine();
        itemNum = rand.nextInt(300) + 1;
        amount = rand.nextInt(30) + 1;
        price  = rand.nextInt(100) + 1;
        l4.setItemNumber(String.valueOf(itemNum));
        l4.setQuantity(amount);
        l4.setUnitPrice(new BigDecimal(price));
        l4.setOrderHeader(h1);
        List<OrderLine> orderLines= new ArrayList<OrderLine>();
        orderLines.add(l1);
        orderLines.add(l2);
        orderLines.add(l3);
        orderLines.add(l4);
        h1.setOrderLine(orderLines);
        orderService.save(h1);

        return "Insert successfully";
    }
}
