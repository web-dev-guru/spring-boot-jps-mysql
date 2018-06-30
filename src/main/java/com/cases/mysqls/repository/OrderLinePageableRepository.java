package com.cases.mysqls.repository;

import com.cases.mysqls.bean.OrderLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderLinePageableRepository extends JpaRepository<OrderLine,Long>  {
    @Query(value="select * from order_line l where l.quantity=:quantity",nativeQuery = true)
    Page<OrderLine> findByStr(@Param("quantity") String quantity, Pageable pageable);
}
