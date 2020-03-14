package com.jobScheduler.jobdemo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@DynamoDBTable(tableName = "dev-users")
public class User {

	@DynamoDBHashKey(attributeName = "userId")
	@DynamoDBAutoGeneratedKey
	private final String userId;

	@DynamoDBAttribute(attributeName = "userName")
	private final String userName;

	@DynamoDBAttribute(attributeName = "email")
	private final String email;

	@DynamoDBAttribute(attributeName = "phoneNumber")
	private final String phoneNumber;

	private User(UserBuilder userBuilder) {
		this.userId = userBuilder.userId;
		this.userName = userBuilder.userName;
		this.email = userBuilder.email;
		this.phoneNumber = userBuilder.phoneNumber;
	}

	@JsonCreator
	public User(@JsonProperty("userId") String userId, @JsonProperty("userName") String userName,
			@JsonProperty("email") String email, @JsonProperty("phoneNumber") String phoneNumber) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getUserId() {
		return userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}

	public static class UserBuilder {
		private final String userId;
		private String userName;
		private String email;
		private String phoneNumber;

		public UserBuilder(String userId) {
			this.userId = userId;
		}

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