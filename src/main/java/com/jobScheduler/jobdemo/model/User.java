package com.jobScheduler.jobdemo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@DynamoDBTable(tableName = "dev-users")
public class User {

	@DynamoDBHashKey(attributeName = "userId")
	@DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
	private String userId;

	@DynamoDBAttribute(attributeName = "userName")
	private String userName;

	@DynamoDBAttribute(attributeName = "email")
	private String email;

	@DynamoDBAttribute(attributeName = "phoneNumber")
	private String phoneNumber;

	private User(UserBuilder userBuilder) {
		this.userName = userBuilder.userName;
		this.email = userBuilder.email;
		this.phoneNumber = userBuilder.phoneNumber;
	}
	
	public User() {
		
	}

	@JsonCreator
	public User(@JsonProperty("userName") String userName, @JsonProperty("email") String email,
			@JsonProperty("phoneNumber") String phoneNumber) {
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}

	public static class UserBuilder {
		private String userName;
		private String email;
		private String phoneNumber;

		public UserBuilder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder phone(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		// Return the finally constructed User object
		public User build() {
			User user = new User(this);
			validateUserObject(user);
			return user;
		}

		private void validateUserObject(User user) {
			// Do some basic validations to check
			// if user object does not break any assumption of system
		}

	}

}
