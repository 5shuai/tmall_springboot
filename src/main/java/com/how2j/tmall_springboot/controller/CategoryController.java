package com.how2j.tmall_springboot.controller;

import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.service.CategoryService;
import com.how2j.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuss.
 * @date 2019/6/6 14:04
 */

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return categoryService.list(start, size, 5);
    }
}


