package com.how2j.tmall_springboot.controller;

import com.how2j.tmall_springboot.Enum.TypeEnum;
import com.how2j.tmall_springboot.pojo.Product;
import com.how2j.tmall_springboot.pojo.ProductImage;
import com.how2j.tmall_springboot.service.ProductImageService;
import com.how2j.tmall_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products/{pid}/productImages")
    public List<ProductImage> list(@PathVariable(value = "pid") int pid,
                                   @RequestParam(value = "type") String type) {
        Product product = productService.get(pid);
        if (type.equals(TypeEnum.type_single.getType())) {
            return productImageService.listSingleProductImages(product);
        } else if (type.equals(TypeEnum.type_detail.getType())) {
            return productImageService.listDetailProductImages(product);
        } else {
            return new ArrayList<>();
        }
    }

    @PostMapping("/productImages")
    public Object add(@RequestParam(value = "pid") int pid,
                      @RequestParam(value = "type") String type,
                      MultipartFile multipartFile, HttpServletRequest request) {
        return productImageService.add(pid, type, multipartFile, request);
    }

    @DeleteMapping(value = "/productImages/{id}")
    public String delete(@PathVariable(value = "id") int id, HttpServletRequest request) throws Exception {
        return productImageService.delete(id, request);
    }
}
