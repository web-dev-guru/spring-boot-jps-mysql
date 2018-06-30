package com.cases.mysqls.service;

import com.cases.mysqls.bean.OrderLine;
import com.cases.mysqls.repository.OrderLinePageableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Service
public class LinePageableServiceImpl implements LinePageableService {
    @Autowired
    OrderLinePageableRepository lineRepository;
    @Override
    public Page<OrderLine> findAll() {
        Pageable pageable = new PageRequest(1, 3, Sort.Direction.ASC, "lineId");
        Page<OrderLine> o =lineRepository.findAll(pageable);
        return o;
    }
}
