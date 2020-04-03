package com.example.demo.config;

import com.example.demo.listener.JobCompletionNotificationListener;
import com.example.demo.entity.Person;
import com.example.demo.processor.PersonItemProcessor;
import com.example.demo.listener.StepCompletionNotificationListener;
import lombok.Data;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @ClassName HelloWorldJobConfig
 * @Description: 配置Hello World Spring Batch 作业
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
@Configuration
public class HelloWorldJobConfig {

    /**
     * @MethodName: helloWorlJob
     * @Description: 创建作业
     * @Param: [jobBuilders, stepBuilders]
     * @Return: org.springframework.batch.core.Job
     * @Author: hh
     * @Date: 2020/4/2
    **/
    @Bean
    public Job helloWorldJob(JobBuilderFactory jobBuilders,
                            StepBuilderFactory stepBuilders,
                            JobCompletionNotificationListener jobListener) {
        return jobBuilders.get("helloWorldJob")
                .start(helloWorldStep(stepBuilders)).listener(jobListener).build();
    }

    /**
     * @MethodName: helloWorldStep
     * @Description: 创建步骤
     * @Param: [stepBuilders]
     * @Return: org.springframework.batch.core.Step
     * @Author: hh
     * @Date: 2020/4/2
    **/
    @Bean
    public Step helloWorldStep(StepBuilderFactory stepBuilders) {
        //chunk()指定每个事务中处理的项的数量，Chunk还指定步骤的输入(Person)和输出(String)类型
        //然后，我们将ItemReader (reader)、ItemProcessor (processor)和ItemWriter (writer)添加到步骤中。
        return stepBuilders.get("helloWorldStep")
                .<Person, String>chunk(10).reader(reader())
                .processor(processor()).writer(writer()).build();
    }

    /**
     * @MethodName: reader
     * @Description: FlatFileItemReader读取person CSV文件
     * @Param: []
     * @Return: org.springframework.batch.item.file.FlatFileItemReader<com.example.demo.Person>
     * @Author: hh
     * @Date: 2020/4/2
    **/
    @Bean
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("csv/persons.csv"))
                .delimited().names(new String[] {"firstName", "lastName"})
                .targetType(Person.class).build();
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<String> writer() {
        return new FlatFileItemWriterBuilder<String>()
                .name("greetingItemWriter")
                .resource(new FileSystemResource(
                        "target/test-outputs/greetings.txt"))
                .lineAggregator(new PassThroughLineAggregator<>()).build();
    }
}
