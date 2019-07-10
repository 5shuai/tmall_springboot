package com.how2j.tmall_springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author wuss.
 * @date 2019/7/10 17:03
 */

@Data
@Entity
@Table(name = "property")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private int name;


    @ManyToOne
    @JoinColumn(name = "cid")

    private Category category;
}
