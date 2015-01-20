package com.mapbar.mq.activemq.producer;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender {
	@Autowired
	private JmsTemplate template;
	@Autowired
	private ActiveMQDestination destination;
	
	public void send(Object obj){
		template.convertAndSend(destination, obj);
	}
	
}
