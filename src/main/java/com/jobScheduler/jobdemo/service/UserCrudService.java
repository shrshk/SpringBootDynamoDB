package com.jobScheduler.jobdemo.service;

import com.jobScheduler.jobdemo.model.User;

public interface UserCrudService {
	public User createUser(User user);

	public User readUser(String userId);

	public User updateUser(User user);

	public void deleteUser(String userId);
}
