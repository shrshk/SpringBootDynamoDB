package com.jobScheduler.jobdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobScheduler.jobdemo.dao.impl.UserCrudDao;
import com.jobScheduler.jobdemo.model.User;
import com.jobScheduler.jobdemo.service.UserCrudService;

@Component
public class UserCrudServiceImpl implements UserCrudService {

	private UserCrudDao userCrudDao;

    @Autowired
    public UserCrudServiceImpl(UserCrudDao userCrudDao) {
        this.userCrudDao = userCrudDao;
    }

    @Override
    public User createUser(User user) {
        return userCrudDao.createUser(user);
    }

    @Override
    public User readUser(String userId) {
        return userCrudDao.readUser(userId);
    }

    @Override
    public User updateUser(User user) {
        return userCrudDao.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        userCrudDao.deleteUser(userId);
    }
	
}
