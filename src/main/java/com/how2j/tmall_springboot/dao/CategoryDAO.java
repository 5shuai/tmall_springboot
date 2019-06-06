package com.how2j.tmall_springboot.dao;

import com.how2j.tmall_springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuss.
 * @date 2019/6/6 13:59
 */


public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
