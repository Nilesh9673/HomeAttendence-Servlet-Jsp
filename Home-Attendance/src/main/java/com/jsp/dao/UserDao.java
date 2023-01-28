package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.jsp.dto.UserDto;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save User
	public UserDto saveUser(UserDto user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	// get by id
	public UserDto getById(int id) {
		UserDto user = entityManager.find(UserDto.class, id);
		return user;
	}

	// get all
	public List<UserDto> getAllUser() {
		String sql = "select u from UserDto u";
		Query query = entityManager.createQuery(sql);
		List<UserDto> user = query.getResultList();
		return user;
	}

	// login veryfy
	public boolean verify(String userName, String passWord) {
		String sql = "select u from UserDto u where u.username=?1 and  u.password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, userName);
		query.setParameter(2, passWord);
		UserDto userDto = (UserDto) query.getSingleResult();
		if (userDto != null) {

			return true;
		}
		return false;
	}

	// get user id
	public int userId(String userName, String passWord) {
		String sql = "select u from UserDto u where u.username=?1 and  u.password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, userName);
		query.setParameter(2, passWord);
		UserDto userDto = (UserDto) query.getSingleResult();
		return userDto.getId();
	}

}
