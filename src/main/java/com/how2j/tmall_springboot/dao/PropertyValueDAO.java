package com.how2j.tmall_springboot.dao;

import com.how2j.tmall_springboot.pojo.Product;
import com.how2j.tmall_springboot.pojo.Property;
import com.how2j.tmall_springboot.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer> {
    PropertyValue getByProductAndProperty(Product product, Property property);
    List<PropertyValue> findByProductOrderByIdDesc(Product product);
}
