package com.rs.criteria.app.repo;

import java.util.Collection;

import com.rs.criteria.app.model.User;

public interface UserRepoAdditional {
	Collection<User> fetchAllUsers();

	Collection<User> fetchAllUsersAsc(String ascAtributeName);

	Collection<User> fetchAllUsersAscOrDesc(String attributeName, boolean ascending);

	Collection<User> fetchAllUserByOrderAndFilter(String attributeName, boolean ascending, String filter);
}
