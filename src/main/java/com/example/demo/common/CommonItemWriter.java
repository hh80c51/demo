package com.example.demo.common;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName UserItemWriter
 * @Description: 对读取的数据进行处理
 * @Author hh
 * @Date 2020/4/7
 * @Version V1.0
 **/
@Component
@StepScope
public class CommonItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> items) throws Exception {
        items.stream().forEach(System.out::println);
    }
}
