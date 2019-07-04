package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.dao.CategoryDAO;
import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);

        Page pageFromJPA = categoryDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    public void add(Category category){
        categoryDAO.save(category);
    }
}
