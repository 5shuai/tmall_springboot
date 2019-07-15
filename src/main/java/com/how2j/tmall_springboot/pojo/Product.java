package com.how2j.tmall_springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wuss.
 * @date 2019/7/15 14:04
 */

@Data
@Entity
@Table(name = "product")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;
}
