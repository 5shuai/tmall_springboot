package com.how2j.tmall_springboot.controller;

import com.how2j.tmall_springboot.pojo.PropertyValue;
import com.how2j.tmall_springboot.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {
    @Autowired
    private PropertyValueService propertyValueService;

    @GetMapping("/product/{pid}/propertyValues")
    public List<PropertyValue> getPropertyValues(@PathVariable(name = "pid") int pid){
        return propertyValueService.getPropertyValues(pid);
    }

    @PutMapping(name = "/propertyValues")
    public Object update(@RequestBody PropertyValue bean) {
        propertyValueService.update(bean);
        return bean;
    }

}
