/**
 * 
 */
package com.example.integrationjms.endpoints;

import org.springframework.messaging.Message;

/**
 * @author user
 *
 */
public class PrintServiceDirectChannelOnly {

	public void print(Message<String> message) {
		System.out.println("Message is : " + message.getPayload());
		System.out.println("Headers are : " + message.getHeaders());
	}
}
