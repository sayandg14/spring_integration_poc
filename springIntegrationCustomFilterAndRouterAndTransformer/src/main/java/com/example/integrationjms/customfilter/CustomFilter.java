package com.example.integrationjms.customfilter;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import com.example.integrationjms.dto.Person;

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
		System.out.println("Within Filter RollNo : "+ ((Person)message.getPayload()).getRollNo() );
		int rollNo = ((Person)message.getPayload()).getRollNo();
		return rollNo == 1 || rollNo == 3 || rollNo == 6 || rollNo ==9;
	}

}
