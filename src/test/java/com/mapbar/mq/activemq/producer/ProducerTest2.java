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
 * 使用主题的模式，如果一个主题配置了多个消费者， 那么这种模式下，一个消息可以被多个消费者共同接收，是一种广播的模式
 * 
 * 
 * @author wupeng
 *
 */
@ContextConfiguration(locations={"classpath:application-producer2.xml"})
public class ProducerTest2 extends AbstractJUnit4SpringContextTests{
	@Autowired
	MessageSender sender;
	
	@Test
	public void testSend() throws InterruptedException{
		Random rand = new Random();
		for(int i = 0; i < 100000; i++){
			SimpleModel model = new SimpleModel(String.valueOf(rand.nextInt()), System.currentTimeMillis()+""); 
			sender.send(model);
			System.out.println("send message ok !");
			TimeUnit.MILLISECONDS.sleep(500);
		}
		System.out.println("ok");
	}
	
}
