package com.MovieApplication.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MovieApplication.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select u from User u where u.username= :username and u.password= :password and u.userRole=:userRole ")
	public User validateUser(String username, String password, String userRole);// login

	@Query(value = "select u from User u where u.username= :username and u.petname= :petname")
	public User RequestValue(String username, String petname);

//	@Query(value="select id from User u where u.username= :username")
//	public User validate(String username);

}
