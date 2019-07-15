package com.how2j.tmall_springboot.dao;

import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuss.
 * @date 2019/7/15 14:20
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {
    Page<Product> findByCategory(Pageable pageable, Category category);
}
