package com.webapp.repository;

import java.util.List;

import com.webapp.model.User;

public interface UserRepository {

	public int insert(User u);
	
	public int update(User u);
	
	public int delete(User u);
	
	public List<User> getAll();
	
	public User getById(int id);
	
	public User getByNick(String nickname);
	
	public boolean existsNickname(String nickname);
	
}
