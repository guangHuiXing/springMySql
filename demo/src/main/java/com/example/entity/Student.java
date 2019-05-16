package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by XGH on 2019/5/15
 */
@Data
public class Student implements Serializable {
    private String name;
    private int id;
    private int teacherId;
}
