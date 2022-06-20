package com.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

	private int userId;
	private String firstName;
	private String lastName;

	/*
	 * public long getUserId() { return userId; }
	 * 
	 * public void setUserId(long userId) { this.userId = userId; }
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * @Override public String toString() { return "User [userId=" + userId +
	 * ", firstName=" + firstName + ", lastName=" + lastName + "]"; }
	 */

}
