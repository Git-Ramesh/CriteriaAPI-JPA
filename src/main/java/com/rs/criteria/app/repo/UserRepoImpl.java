package com.rs.criteria.app.repo;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.geo.Circle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rs.criteria.app.model.User;

/*
 * Criteria API mainly useful in retrieving the records based on different conditions provided in.
 */
@Repository
@Transactional
public class UserRepoImpl implements UserRepoAdditional {
	@PersistenceContext
	private EntityManager entityManager;

	public Collection<User> fetchAllUsers() {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		CriteriaQuery<User> select = criteriaQuery.select(from);
		TypedQuery<User> typedQuery = this.entityManager.createQuery(select);
		return typedQuery.getResultList();
	}

	public Collection<User> fetchAllUsersAsc(String ascAtributeName) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		CriteriaQuery<User> criteriaQuery2 = criteriaQuery.select(from)
				.orderBy(criteriaBuilder.asc(from.get(ascAtributeName)));
		TypedQuery<User> typedQuery = this.entityManager.createQuery(criteriaQuery2);
		return typedQuery.getResultList();
	}

	public Collection<User> fetchAllUsersAscOrDesc(String attributeName, boolean ascending) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		CriteriaQuery<User> orderBy = criteriaQuery.select(from)
				.orderBy(new OrderImpl(from.get(attributeName), ascending));
		TypedQuery<User> typedQuery = this.entityManager.createQuery(orderBy);
		return typedQuery.getResultList();
	}

	public Collection<User> fetchAllUserByOrderAndFilter(String attributeName, boolean ascending, String filter) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		CriteriaQuery<User> criteriaQuery2 = criteriaQuery.select(from).where(criteriaBuilder.like(from.get("username"), "%"+filter+"%"));
		CriteriaQuery<User> criteriaQuery3 = criteriaQuery2.orderBy(new OrderImpl(from.get("age"), ascending));
		TypedQuery<User> typedQuery = this.entityManager.createQuery(criteriaQuery3);
		return typedQuery.getResultList();
	}
}
