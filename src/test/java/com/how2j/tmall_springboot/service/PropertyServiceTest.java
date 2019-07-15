package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.pojo.Property;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wuss.
 * @date 2019/7/12 17:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertyServiceTest {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void add() {
        Category category = categoryService.get(2);

        Property property = new Property();

        property.setCategory(category);
        property.setName("weight");
        
        propertyService.add(property);
    }
}