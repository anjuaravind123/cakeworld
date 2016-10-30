package com.cakefactory.UserRole;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDAO {
	public void insert(UserRole r);
	public void update(UserRole r);
	public void delete(int rid);
	public UserRole getUserRole(int rid);
	public List<UserRole> ListUserRole();
	

}
