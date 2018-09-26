package com.rs.criteria.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.rs.criteria.app.model.User;
import com.rs.criteria.app.repo.UserRepo;

@SpringBootApplication
@EntityScan(basePackages = "com.rs.criteria.app.model")
public class CriteriaApiJpaApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(CriteriaApiJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Save all users to db
		//this.saveAllUsers(getUsers()).stream().forEach(System.out::println);
		//Get the saved users
		//getAllSavedUsers().parallelStream().forEach(System.out::println);
		//getAllUsersByAsc("address").stream().forEach(System.out::println);
//		getAllUsersByOrder("username", false).forEach(System.out::println);
		getAllUserByOrderAndFilter("username", true, "R").forEach(System.out::println);
	}
	
	public Collection<User> getUsers() {
		return Arrays.asList(
					new User("Ramesh", 23, "Hyderabad"),
					new User("Kiran", 43, "Bangalore"),
					new User("Reshma", 26, "Pune"), new User("Sowmya", 23, "Hyderabad"));
	}

	private Collection<User> saveAllUsers(Collection<User> users) {
		return this.userRepo.saveAll(users);
	}

	private Collection<User> getAllSavedUsers() {
		return this.userRepo.fetchAllUsers();
	}
	
	private Collection<User> getAllUsersByAsc(String attributeName) {
		return this.userRepo.fetchAllUsersAsc(attributeName);
	}
	
	private Collection<User> getAllUsersByOrder(String attributeName, boolean ascending) {
		return this.userRepo.fetchAllUsersAscOrDesc(attributeName, ascending);
	}
	
	private Collection<User> getAllUserByOrderAndFilter(String attributeName, boolean ascending, String filter) {
		return this.userRepo.fetchAllUserByOrderAndFilter(attributeName, ascending, filter);
	}
}
