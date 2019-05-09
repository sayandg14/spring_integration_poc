package com.example.integrationjms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.example.integrationjms.endpoints.PrintGateway;

@SpringBootApplication
@ImportResource("integrationbeans.xml")
public class SpringIntegrationWithJmsApplication implements ApplicationRunner{

	/*
	 * @Autowired DirectChannel inboundChannel;
	 */
	
	@Autowired
	PrintGateway printGateway;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationWithJmsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Future<Message<String>>> futures = new ArrayList();
		
		for(int x=0;x<10;x++) {
			Message<String> message = MessageBuilder.withPayload("Printing message payload for : " + x)
					.setHeader("messageNumber", x).build();
			System.out.println("Sending message : "+ x);
			futures.add(this.printGateway.print(message));
		}
		System.out.println("Waiting .................");
		for(Future<Message<String>> future:futures) {
			System.out.println("Response : "+future.get().getPayload());
		}
		
	}

	/*	For Direct Channel Only	*/
	/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		inboundChannel.subscribe(new MessageHandler() {
			
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				new PrintServiceirectChannelOnly().print((Message<String>)message);
				
			}
		});
		
		Message<String> message = MessageBuilder.withPayload("Hi Sayan Creating First message").setHeader("Header_Sayan", "Sayan Dasgupta").build();
		inboundChannel.send(message);
	}
	*/
	
	

}
