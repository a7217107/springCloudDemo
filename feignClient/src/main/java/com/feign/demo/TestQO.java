package com.feign.demo;

import lombok.Data;

import java.util.Date;

@Data
public class TestQO {
    private Integer partnerId;
    private Date time = new Date();
}
