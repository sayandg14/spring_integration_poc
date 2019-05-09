package com.example.integrationjms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.example.integrationjms.dto.Person;
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
		List<Future<Message<?>>> futures = new ArrayList<Future<Message<?>>>();
		for(int x=0;x<10;x++) {
			int temp = x+1;
			Person person = new Person(temp, "FirstName_"+temp, "LastName_"+temp);
			Message<?> message = MessageBuilder.withPayload(person)
					.setHeader("messageNumber", temp).build();
			System.out.println("Sending message for person rollNo : "+ person.getRollNo());
			futures.add(this.printGateway.print(message));
		}
		System.out.println("Waiting ................. , futures size : "+futures.size());

		for (Future<Message<?>> future : futures) {
			System.out.println("responses coming : " + futures.size());
			System.out.println("Response : " + ((Person) (future.get().getPayload())));
		}
		
	}

}
