package com.yimoom.pplay.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.yimoom.pplay.constants.ThreadConstants;

/**
定时任务并行执行
常用： 秒、分、时、日、月、年
0 0 10,14,16 * * ? 每天上午10点，下午2点，4点 
0 0 12 * * ? 每天中午12点触发 
0 0 /5 0 * * ? 每5分钟执行一次
 **/
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		scheduledTaskRegistrar.setScheduler(setTaskExecutors());
	}

	@Bean(destroyMethod="shutdown")
	public Executor setTaskExecutors(){
		//延时任务线程池
		return Executors.newScheduledThreadPool(ThreadConstants.SCHEDULE_THREAD_NUM); 
	}
}

