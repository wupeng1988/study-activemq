package com.mapbar.mq.activemq.consumer;

public class CommonConsumer2 {

	public void receive(Object obj){
		System.out.println("listener2  >>>>  " + obj);
	}
	
	public void reciveTopic(Object obj){
		System.out.println("listener4  >>>>  " + obj);
	}
	
}
