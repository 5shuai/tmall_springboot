package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.BasicUnitTest;
import com.how2j.tmall_springboot.dao.CategoryDAO;
import com.how2j.tmall_springboot.dao.ProductDAO;
import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.pojo.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuss.
 * @date 2019/7/15 14:38
 */


public class ProductServiceTestBasic extends BasicUnitTest {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    protected CategoryDAO categoryDAO;

    @Test
    public void add() {
        Category category = categoryDAO.getOne(18);
        Product product = new Product();
        product.setCategory(category);
        product.setCreateDate(new Date());
        product.setName("桂花树");
        product.setOriginalPrice(33.33f);
        product.setPromotePrice(23.45f);
        product.setStock(15);
        product.setSubTitle("美丽的桂花树");
        productDAO.save(product);
    }
}