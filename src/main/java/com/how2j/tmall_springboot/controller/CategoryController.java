package com.how2j.tmall_springboot.controller;

import com.how2j.tmall_springboot.pojo.Category;
import com.how2j.tmall_springboot.service.CategoryService;
import com.how2j.tmall_springboot.util.ImageUtil;
import com.how2j.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;

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

    @PostMapping(value = "/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    @DeleteMapping(value = "/categories/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        if (file.exists()) {
            file.delete();
        }
        categoryService.delete(id);
        return null;
    }

    @GetMapping(value = "/categories/{id}")
    public Category get(@PathVariable("id") int id) {
        return categoryService.get(id);
    }

    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, bean.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @PutMapping(value = "/categories/{id}")
    public Object update(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);
        if (image != null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}


