package net.xdclass.demo2;

import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;
import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ServletComponentScan     //扫描servlet组件 WebFilter
@MapperScan("net.xdclass.demo2.mapper")
//@EnableScheduling               //开启定时任务

@EnableAsync             //开启异步任务
@EnableJms //开启支持jms
public class XdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdclassApplication.class, args);
	}
	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("3MB");
		factory.setMaxRequestSize("3MB");
		return factory.createMultipartConfig();
	}


	@Bean
	public Queue queue(){
		return new ActiveMQQueue("common.queue");
	}
}
