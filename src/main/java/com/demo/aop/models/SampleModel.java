package com.demo.aop.models;

public class SampleModel {

    private String name;

    public SampleModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SampleModel{" + "name='" + name + '\'' + '}';
    }
}
