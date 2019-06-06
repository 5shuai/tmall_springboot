package com.how2j.tmall_springboot.controller;

import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wuss.
 * @date 2019/6/6 14:04
 */

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }
}


