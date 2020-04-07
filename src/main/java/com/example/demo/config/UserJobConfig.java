package com.example.demo.config;

import com.example.demo.common.CommonItemWriter;
import com.example.demo.common.CommonMybatisItemReader;
import com.example.demo.entity.User;
import com.example.demo.processor.UserProcessor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @ClassName UserJobConfig
 * @Description: 作业配置
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
@Configuration
@EnableBatchProcessing
public class UserJobConfig  {

    @Resource
    private JobBuilderFactory jobBuilderFactory;
    @Resource
    private StepBuilderFactory stepBuilderFactory;
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private UserProcessor userProcessor;
    @Resource
    private CommonItemWriter commonItemWriter;

    @Bean
    public Job userJob(){
        return jobBuilderFactory.get("userJob")
                .start(userStep())
                .build();
    }

    @Bean
    public Step userStep(){
        return stepBuilderFactory.get("userStep")
                .<User,String>chunk(10)
                .reader(userReader())
                .processor(userProcessor)
                .writer(commonItemWriter)
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<User> userReader(){
        return new CommonMybatisItemReader<>(sqlSessionFactory,User.class.getSimpleName());
    }

}
