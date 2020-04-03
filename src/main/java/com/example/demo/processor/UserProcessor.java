package com.example.demo.processor;

import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserProcessor
 * @Description: 中间数据处理
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
@Component
@StepScope
public class UserProcessor implements ItemProcessor<User, String> {
    private static final Logger log = LoggerFactory.getLogger(UserProcessor.class);

    @Override
    public String process(User user) throws Exception {
        log.info("打印user信息：{}", user.toString());
        return user.toString();
    }
}
