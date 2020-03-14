package com.jobScheduler.jobdemo.dao.impl;

import com.jobScheduler.jobdemo.model.User;

public interface UserCrudDao {

	public User createUser(User user);

	public User readUser(String userId);

	public User updateUser(User user);

	public void deleteUser(String userId);
}
