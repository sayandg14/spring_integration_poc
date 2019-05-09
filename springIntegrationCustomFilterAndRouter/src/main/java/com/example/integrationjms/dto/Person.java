/**
 * 
 */
package com.example.integrationjms.dto;

/**
 * @author user
 *
 */
public class Person {

	private int rollNo;
	private String fName;
	private String lName;
	private String schoolName;
	
	public Person(int rollNo, String fName, String lName) {
		super();
		this.rollNo = rollNo;
		this.fName = fName;
		this.lName = lName;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
