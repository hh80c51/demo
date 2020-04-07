package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName JdbcServiceImpl
 * @Description: jdbc操作
 * @Author hh
 * @Date 2020/4/7
 * @Version V1.0
 **/

@Service
public class JdbcServiceImpl implements JdbcService {

    @Resource
    private JdbcTemplate jdbc;

    public void insert() {
        jdbc.update("insert into user(name, age) values(?,?)","赵四",23);
    }

}