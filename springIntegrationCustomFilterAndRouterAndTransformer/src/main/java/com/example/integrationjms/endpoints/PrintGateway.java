/**
 * 
 */
package com.example.integrationjms.endpoints;

import java.util.concurrent.Future;

import org.springframework.messaging.Message;

/**
 * @author user
 *
 */
public interface PrintGateway {
	public Future<Message<?>> print(Message<?> message); 

}
