/**
 * 
 */
package com.example.integrationjms.router;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.example.integrationjms.dto.Person;

/**
 * @author user
 *
 */
public class CustomRouter extends AbstractMessageRouter {
	
	@Autowired
	@Qualifier("intChannel")
	private MessageChannel intChannel;
	
	@Autowired
	@Qualifier("stringChannel")
	private MessageChannel stringChannel;
	

	@Override
	protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
		System.out.println("router : " + message.getPayload());
		Collection<MessageChannel> targetChannels = new ArrayList<MessageChannel>();
		if(message.getPayload().getClass().equals(Integer.class)) {
			targetChannels.add(intChannel);
		} else if(message.getPayload().getClass().equals(String.class)) {
			targetChannels.add(stringChannel);
		} else if(message.getPayload().getClass().equals(Person.class)) {
			targetChannels.add(stringChannel);
		} 
		return targetChannels;
	}

}
