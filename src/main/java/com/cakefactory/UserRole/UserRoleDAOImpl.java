package com.cakefactory.UserRole;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cakefactory.user.User;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {
	@Autowired
	SessionFactory  sessionFactory;
	@Transactional
	public void insert(UserRole r) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(r);
	}
	@Transactional
	public void update(UserRole r) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(r);
	}
	@Transactional
	public void delete(int rid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from UserRole r where r.id = :id").setInteger("id", rid).executeUpdate();
	}
	@Transactional
	public UserRole getUserRole(int rid) {
		// TODO Auto-generated method stub
		 List<UserRole> list = sessionFactory.getCurrentSession().createQuery("from UserRole r where r.Role = :id").setInteger("id", rid).list();
			
			if(!list.isEmpty())
			{
				return list.get(0);
			}
			else
				return null;
			}
	@Transactional
	public List<UserRole> ListUserRole() {
		// TODO Auto-generated method stub
		List<UserRole> list = sessionFactory.getCurrentSession().createQuery("from UserRole r").list();
		return null;
	}

}
