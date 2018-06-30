package com.cases.mysqls.repository;

import com.cases.mysqls.bean.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderLinePageableRepository extends JpaRepository<OrderLine,Long>  {
}
