/**
 * 
 */
package com.example.integrationjms;

import org.springframework.messaging.Message;

/**
 * @author user
 *
 */
public class CustomTransformer {

	public String transform(Message<?> message) {
		return message.getPayload() + " " + message.getPayload();
	}
}
