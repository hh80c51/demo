//package com.example.demo.config;
//
//import com.example.demo.common.CommonMybatisItemReader;
//import com.example.demo.common.CommonMybatisItemWriter;
//import com.example.demo.entity.User;
//import com.example.demo.processor.UserProcessor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @ClassName UserJobConfig
// * @Description: 作业配置
// * @Author hh
// * @Date 2020/4/2
// * @Version V1.0
// **/
//@Configuration
//@EnableBatchProcessing
//public class UserJobConfig  {
//
//    private JobBuilderFactory jobBuilderFactory;
//
//    private StepBuilderFactory stepBuilderFactory;
//
//    private SqlSessionFactory sqlSessionFactory;
//
//    private UserProcessor userProcessor;
//
//    public JobBuilderFactory getJobBuilderFactory() {
//        return jobBuilderFactory;
//    }
//
//    public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//    }
//
//    public StepBuilderFactory getStepBuilderFactory() {
//        return stepBuilderFactory;
//    }
//
//    public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
//    public SqlSessionFactory getSqlSessionFactory() {
//        return sqlSessionFactory;
//    }
//
//    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//
//    public UserProcessor getProcessor() {
//        return userProcessor;
//    }
//
//    public void setProcessor(UserProcessor userProcessor) {
//        this.userProcessor = userProcessor;
//    }
//
//    @Bean
//    public Job userJob(){
//        return jobBuilderFactory.get("userJob")
//                .start(userStep())
//                .build();
//    }
//
//    @Bean
//    public Step userStep(){
//        return stepBuilderFactory.get("userStep")
//                .<User,String>chunk(10)
//                .reader(userReader())
//                .processor(userProcessor)
//                .writer(userWriter())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public CommonMybatisItemReader<User> userReader(){
//        return new CommonMybatisItemReader<>(sqlSessionFactory,User.class.getSimpleName());
//    }
//
//    @Bean
//    @StepScope
//    public ItemWriter<? super String> userWriter(){
//        return new CommonMybatisItemWriter<>(sqlSessionFactory,User.class.getSimpleName());
//    }
//}
