package com.example.demo.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName BatchConfig
 * @Description: 配置Spring Batch Job
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

    /**
     * @MethodName: setDataSource
     * @Description: 为了使Spring Batch使用基于Map的JobRepository
     * @Param:
     * @Return:
     * @Author: hh
     * @Date: 2020/4/2
    **/
    @Override
    public void setDataSource(DataSource dataSource) {
        // initialize will use a Map based JobRepository (instead of database)
        //super.setDataSource(dataSource);
    }
}