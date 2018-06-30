package com.cases.mysqls.service;

import com.cases.mysqls.bean.OrderHeader;
import com.cases.mysqls.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderHeader save(OrderHeader orderHeader) {
        return orderRepository.save(orderHeader);
    }

    public Optional<OrderHeader> findAllById(Long id){
        Optional<OrderHeader> optionalOrder = orderRepository.findById(id);
        return optionalOrder;
    }
}
