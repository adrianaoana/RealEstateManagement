package com.squad.service;

import java.util.List;

import com.squad.model.User;

public interface UserService {

	public int add(User user);

	public int update(User user);

	public void delete(String email);

	public List<User> getAll();

	public User getByEmail(String email);

	public boolean checkDuplicate(User user);

	public List<User> simulateSearchResult(String email);

	public int updatePassword(String name, String password);
}
