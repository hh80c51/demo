package com.example.demo.entity;

/**
 * @ClassName Person
 * @Description: 用户数据库映射
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
public class Person {
    private String firstName;
    private String lastName;

    public Person() {
        // default constructor
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}