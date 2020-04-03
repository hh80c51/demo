package com.example.demo.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

/**
 * @ClassName UserJobConfig
 * @Description: 读数据库
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
public class CommonMybatisItemReader<T> extends MyBatisPagingItemReader<T> {

    public CommonMybatisItemReader(SqlSessionFactory sqlSessionFactory,String name) {
        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.example.demo."+name+".selectList");
        setPageSize(100);
    }
}
