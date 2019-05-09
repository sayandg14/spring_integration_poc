/**
 * 
 */
package com.example.integrationjms.transformer;

import org.springframework.messaging.Message;

import com.example.integrationjms.dto.Person;

/**
 * @author user
 *
 */
public class CustomTransformer {

	public Person transform(Message<?> message) {
		Person person = (Person)message.getPayload();
		person.setSchoolName("Jadavpir Vidyapith");
		return person;
	}
}
