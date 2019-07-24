package com.how2j.tmall_springboot.Enum;

import lombok.Getter;

@Getter
public enum TypeEnum {

    type_single("single"),
    type_detail("detail");


    TypeEnum(String type) {
        this.type = type;
    }

    private String type;
}
