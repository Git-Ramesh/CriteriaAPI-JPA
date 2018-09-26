package com.rs.criteria.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "user_tab")
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {
	private static final long serialVersionUID = 5001426685911619509L;

	private String username;
	private int age;
	private String address;

	public User() {
		super();
	}

	public User(String username, int age, String address) {
		super();
		this.username = username;
		this.age = age;
		this.address = address;
	}

	@Id
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", address=" + address + "]";
	}
}
