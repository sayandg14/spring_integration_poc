package com.example.integrationjms.customfilter;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

/**
 * 
 */

/**
 * @author user
 *
 */
public class CustomFilter implements MessageSelector {

	@Override
	public boolean accept(Message<?> message) {
		return message.getPayload().equals(7) || message.getPayload().equals(8) || message.getPayload().equals(9);
	}

}
