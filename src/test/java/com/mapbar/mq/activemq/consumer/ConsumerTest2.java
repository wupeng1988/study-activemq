package com.mapbar.mq.activemq.consumer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class ConsumerTest2 {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer2.xml"});
	}
	
}
