package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.dao.CategoryDAO;
import com.how2j.tmall_springboot.dao.ProductDAO;
import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.pojo.Product;
import com.how2j.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author wuss.
 * @date 2019/7/15 14:32
 */
@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    protected CategoryDAO categoryDAO;

    public void add(Product product) {
        productDAO.save(product);
    }

    public void update(Product product) {
        productDAO.save(product);
    }

    public void delete(int id) {
        productDAO.deleteById(id);
    }

    public Product get(int id) {
        return productDAO.getOne(id);
    }

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryDAO.getOne(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Product> products = productDAO.findByCategory(pageable, category);
        return new Page4Navigator<>(products, navigatePages);
    }
}
