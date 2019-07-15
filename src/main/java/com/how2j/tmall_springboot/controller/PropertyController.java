package com.how2j.tmall_springboot.controller;

import com.how2j.tmall_springboot.pojo.Property;
import com.how2j.tmall_springboot.service.PropertyService;
import com.how2j.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuss.
 * @date 2019/7/12 15:12
 */
@RestController
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid") int cid,
                                         @RequestParam(value = "start", defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return propertyService.list(cid, start, size, 5);
    }

    @GetMapping(value = "/properties/{id}")
    public Property get(@PathVariable("id") int id) {
        return propertyService.get(id);
    }

    @PostMapping(value = "/properties")
    public Object add(@RequestBody Property bean) throws Exception {
        propertyService.add(bean);
        return bean;
    }

    @DeleteMapping(value = "/properties/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        propertyService.delete(id);
        return null;
    }

    @PutMapping(value = "/properties")
    public Object update(@RequestBody Property property) throws Exception {
        propertyService.update(property);
        return property;
    }
}
