package com.how2j.tmall_springboot.dao;

import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuss.
 * @date 2019/7/10 17:14
 */
public interface PropertyDAO extends JpaRepository<Property, Integer> {
    /**
     * 根据category获取Property
     * @param category
     * @param pageable
     * @return
     */
    Page<Property> findByCategory(Category category, Pageable pageable);
    List<Property> findByCategory(Category category);
}
