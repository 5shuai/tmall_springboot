package com.how2j.tmall_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wuss.
 * @date 2019/6/6 14:05
 */

@Controller
public class AdminPageController {
    @GetMapping(value = "/admin")
    public String admin() {
        return "redirect:admin_category_list";
    }

    @GetMapping(value = "/admin_category_list")
    public String listCategory() {
        return "admin/listCategory";
    }

    @GetMapping(value = "/admin_category_edit")
    public String editCategory() {
        return "admin/editCategory";
    }

    @GetMapping(value = "/admin_property_list")
    public String listProperty() {
        return "admin/listProperty";
    }

    @GetMapping(value = "/admin_property_edit")
    public String editProperty() {
        return "admin/editProperty";
    }

    @GetMapping(value = "/admin_propertyValue_edit")
    public String editPropertyValue() {
        return "admin/editPropertyValue";
    }

    @GetMapping(value = "/admin_product_list")
    public String listProduct() {
        return "admin/listProduct";
    }

    @GetMapping(value = "/admin_product_edit")
    public String editProduct() {
        return "admin/editProduct";
    }

    @GetMapping(value = "/admin_productImage_list")
    public String listProductImages() {
        return "admin/listProductImage";
    }
}
