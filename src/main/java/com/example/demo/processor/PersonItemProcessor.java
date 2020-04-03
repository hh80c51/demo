package com.example.demo.processor;

import com.example.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @ClassName PersonItemProcessor
 * @Description: 中间数据处理处理器
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
public class PersonItemProcessor implements ItemProcessor<Person, String> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello " + person.getFirstName() + " "
                + person.getLastName() + "!";

        log.info("converting '{}' into '{}'", person, greeting);
        return greeting;
    }

}