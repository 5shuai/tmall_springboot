package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.dao.CategoryDAO;
import com.how2j.tmall_springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuss.
 * @date 2019/6/6 14:00
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }
}
