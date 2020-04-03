package com.example.demo.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

/**
 * @ClassName UserJobConfig
 * @Description: 写数据库
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
public class CommonMybatisItemWriter<T> extends MyBatisBatchItemWriter<T> {

    public  CommonMybatisItemWriter(SqlSessionFactory sqlSessionFactory,String name) {
        setSqlSessionFactory(sqlSessionFactory);
        setStatementId("com.example.demo." + name + ".insert");
        setAssertUpdates(false);
    }


}
