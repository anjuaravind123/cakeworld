package com.cakefactory.UserRole;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserRole{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private int Role;
	private String RoleName;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

}
