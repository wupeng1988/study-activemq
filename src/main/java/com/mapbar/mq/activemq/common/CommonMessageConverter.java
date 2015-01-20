package com.mapbar.mq.activemq.common;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CommonMessageConverter implements MessageConverter{

	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		
		if(message instanceof ActiveMQTextMessage){
			String text = ((ActiveMQTextMessage) message).getText();
			return JsonUtil.fromJson(text, SimpleModel.class);
		} else {
			System.out.println("message is unrecognized !!! clazz : " + message.getClass().getName());
		}
		
		
		return null;
	}

	@Override
	public Message toMessage(Object obj, Session session) throws JMSException,
			MessageConversionException {
		
		String text = "";
		try {
			text = JsonUtil.toJson(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return session.createTextMessage(text);
	}
	
	
	
}
