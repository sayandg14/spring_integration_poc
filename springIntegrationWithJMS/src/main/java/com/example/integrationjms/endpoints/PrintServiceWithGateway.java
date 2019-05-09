/**
 * 
 */
package com.example.integrationjms.endpoints;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * @author user
 *
 */
public class PrintServiceWithGateway {
	
	public Message<String> getMessage(Message<String> message) {
		System.out.println("Service End point reached : "+message.getPayload());
		int messageNumber = (int)message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload("Sending a reply to Message "+messageNumber).build();
	}

}
