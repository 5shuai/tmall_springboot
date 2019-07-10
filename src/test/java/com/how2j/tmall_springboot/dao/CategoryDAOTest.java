package com.how2j.tmall_springboot.dao;

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
}