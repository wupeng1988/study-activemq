package com.mapbar.mq.activemq.consumer;


public class CommonConsumer{
	
	public void receive(Object obj){
		System.out.println("listener1  >>>>  " + obj);
	}
	
	public void reciveTopic(Object obj){
		System.out.println("listener3  >>>>  " + obj);
	}
	
}
