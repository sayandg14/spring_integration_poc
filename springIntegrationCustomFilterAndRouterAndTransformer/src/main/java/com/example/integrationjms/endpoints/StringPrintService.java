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
public class StringPrintService {
	
	public void print(Message<?> message) {
		System.out.println("String Service End point reached : "+message.getPayload());
		//return MessageBuilder.withPayload(message.getPayload()).build();
	}

}
