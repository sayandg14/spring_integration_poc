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
public class NumericPrintService {
	
	public void print(Message<?> message) {
		System.out.println("Integer Service End point reached : "+message.getPayload());
	}

}
