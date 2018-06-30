package com.cases.mysqls.repository;

import com.cases.mysqls.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value="SELECT p.image_url FROM product p where p.description = :desc",nativeQuery = true)
    List<String> findByStr(@Param("desc") String desc);

    @Modifying
    @Transactional
    @Query(value="update product p set p.image_url = :url where p._id = 1",nativeQuery = true)
    int updateStrByStr(@Param("url") String url);



}
