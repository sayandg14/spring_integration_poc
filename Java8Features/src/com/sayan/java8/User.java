/**
 * 
 */
package com.sayan.java8;

/**
 * @author user
 *
 */
public class User {

	private String name;
	
	
	public User(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isLegalName(String name) {
		if(name.equals("Sayan")) {
			return true;
		} else {
			return false;
		}
	}
}
