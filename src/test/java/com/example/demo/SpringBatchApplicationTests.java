package com.example.demo;

import com.example.demo.config.BatchConfig;
import com.example.demo.config.HelloWorldJobConfig;
import com.example.demo.listener.JobCompletionNotificationListener;
import com.example.demo.listener.StepCompletionNotificationListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.batch.operations.NoSuchJobException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ClassName SpringBatchApplicationTests
 * @Description: 测试Spring Batch 示例
 * @Author hh
 * @Date 2020/4/2
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {SpringBatchApplicationTests.BatchTestConfig.class})
public class SpringBatchApplicationTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testHelloWorldJob() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertThat(jobExecution.getExitStatus().getExitCode())
                .isEqualTo("COMPLETED");
    }

    @Configuration
    @Import({BatchConfig.class, HelloWorldJobConfig.class, JobCompletionNotificationListener.class, StepCompletionNotificationListener.class})
    static class BatchTestConfig {

        @Autowired
        private Job helloWorlJob;

        @Bean
        JobLauncherTestUtils jobLauncherTestUtils()
                throws NoSuchJobException {
            JobLauncherTestUtils jobLauncherTestUtils =
                    new JobLauncherTestUtils();
            jobLauncherTestUtils.setJob(helloWorlJob);

            return jobLauncherTestUtils;
        }

    }
}