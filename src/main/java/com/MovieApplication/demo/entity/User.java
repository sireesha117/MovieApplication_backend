package com.MovieApplication.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class User 
{	
	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String username;
	private String password;
	private String userRole="customer";
	private String email;
	private String petname;
	public User() {}
	
	public User(String username, String password, String email, String petname) {
		super();
		this.username = username;
		this.password = password;
		
		this.email = email;
		this.petname = petname;
	}
	public User(String username, String password,String UserRole) {
		super();
		this.username = username;
		this.password = password;
		this.userRole=userRole;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}	

}