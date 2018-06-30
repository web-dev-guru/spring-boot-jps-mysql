package com.cases.mysqls.repository;


import com.cases.mysqls.bean.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<OrderHeader, Long> {

}
