package com.mapbar.mq.activemq.producer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.mapbar.mq.activemq.common.SimpleModel;
/**
 * 
 * 使用队列的方式，这种方式下，如果一个队列配置了多个监听，那么多个监听是一个争抢的关系，一个消息只能被一个消费者消费
 * 
 * @author wupeng
 *
 */
@ContextConfiguration(locations={"classpath:application-producer.xml"})
public class ProducerTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	MessageSender sender;
	
	@Test
	public void testSend() throws InterruptedException{
		Random rand = new Random();
		long start = System.currentTimeMillis();
		for(int i = 0; i < 200000; i++){
			SimpleModel model = new SimpleModel(String.valueOf(rand.nextInt()), System.currentTimeMillis()+""); 
			sender.send(model);
		}
		System.out.println("time : " + (System.currentTimeMillis() - start));
		System.out.println("ok");
	}
	
}
