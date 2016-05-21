package com.squad.dao;

import java.util.List;

import com.squad.model.User;

public interface UserDAO {

	public void add(User user);

	public void update(User user);

	public void delete(User user);

	public List<User> getAll();

	public User getByEmail(String username);

}
