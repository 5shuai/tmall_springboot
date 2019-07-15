package com.how2j.tmall_springboot.dao;

import com.how2j.tmall_springboot.pojo.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wuss.
 * @date 2019/6/6 14:36
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDAOTest {
    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    public void get() {
        int id = 2;
        Category category = categoryDAO.getOne(id);
        Assert.assertEquals(category.getId(), id);
    }
}