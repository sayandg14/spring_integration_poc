/*
 * Run Active MQ by this url : http://localhost:8161/admin  username : admin , password : admin
 * 
 */

package com.example.integrationjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.example.integrationjms.dto.Person;
import com.example.integrationjms.endpoints.PersonGateway;

@SpringBootApplication
@ImportResource("integrationbeans.xml")
public class SpringIntegrationWithJmsApplication implements ApplicationRunner{

	/*
	 * @Autowired DirectChannel inboundChannel;
	 */
	
	@Autowired
	PersonGateway gateway;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationWithJmsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Person person1 = new Person(1,"Sayan","Dasgupta");
		Person person2 = new Person(1,"Sanjukta","Dasgupta");
		
		this.gateway.save();
		System.out.println("Message has been sent");
	}

}
