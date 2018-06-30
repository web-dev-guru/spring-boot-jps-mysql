package com.cases.mysqls.service;

import com.cases.mysqls.bean.OrderLine;
import org.springframework.data.domain.Page;

public interface LinePageableService {
    Page<OrderLine> findAll();
    Page<OrderLine> findByStr(int quantity);
}
