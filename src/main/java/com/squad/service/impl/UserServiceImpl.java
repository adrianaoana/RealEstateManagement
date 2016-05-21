package com.squad.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.squad.dao.UserDAO;
import com.squad.model.User;
import com.squad.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public int add(User user) {
		if (checkDuplicate(user)) {
			userDAO.add(user);
			return 0;
		}
		return 1;
	}

	@Override
	@Transactional
	public int update(User user) {
		userDAO.update(user);
		return 0;
	}

	@Override
	@Transactional
	public int updatePassword(String email, String password) {
		User user = userDAO.getByEmail(email);
		user.setPassword(password);
		userDAO.update(user);
		return 0;
	}

	@Override
	@Transactional
	public void delete(String email) {
		User user = userDAO.getByEmail(email);
		if (user != null) {
			userDAO.delete(user);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User getByEmail(String email) {
		return userDAO.getByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean checkDuplicate(User user) {
		User existingUser = userDAO.getByEmail(user.getEmail());
		if (existingUser != null) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> simulateSearchResult(String email) {

		List<User> result = new ArrayList<User>();
		List<User> users = userDAO.getAll();

		for (User user : users) {
			if (user.getEmail().contains(email)) {
				result.add(user);
			}
		}

		return result;
	}

}
