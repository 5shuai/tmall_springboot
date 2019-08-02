package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.dao.PropertyValueDAO;
import com.how2j.tmall_springboot.pojo.Product;
import com.how2j.tmall_springboot.pojo.Property;
import com.how2j.tmall_springboot.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {
    @Autowired
    private PropertyValueDAO propertyValueDAO;

    @Autowired
    private ProductService productService;

    @Autowired
    private PropertyService propertyService;

    public void update(PropertyValue bean) {
        propertyValueDAO.save(bean);
    }

    public void init(Product product) {
        List<Property> properties = propertyService.listByCategory(product.getCategory());
        for (Property property : properties) {
            PropertyValue propertyValue = propertyValueDAO.getByProductAndProperty(product, property);
            if (propertyValue == null) {
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    public List<PropertyValue> getPropertyValues(int pid) {
        Product product = productService.get(pid);
        if (product == null) {
            return null;
        }
        init(product);
        return propertyValueDAO.findByProductOrderByIdDesc(product);
    }

    public void updatePropertyValues(List<PropertyValue> propertyValues) {
        propertyValueDAO.saveAll(propertyValues);
    }

    public PropertyValue getByProductAndProperty(Product product, Property property) {
        return propertyValueDAO.getByProductAndProperty(product, property);
    }
}
