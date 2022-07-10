package com.example.demo.model;

import lombok.Data;

@Data
public class Test1 {
    private Integer id;
    private String a;
    private String b;
    private String c;

    public Test1() {
    }

    public Test1(Integer id, String a, String b, String c) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Test1(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
