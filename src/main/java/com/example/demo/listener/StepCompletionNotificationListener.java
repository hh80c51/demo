package com.example.demo.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * @ClassName StepCompletionNotificationListener
 * @Description: TODO
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
public class StepCompletionNotificationListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("step执行开始");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("step执行结束");
        return null;
    }
}
