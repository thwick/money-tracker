package org.thwick.moneytracker.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.thwick.moneytracker.models.Transaction;

public class TransactionDAO extends AbstractDAO<Transaction> {

	public TransactionDAO() {
		super();
	}
	
	public List<Transaction> findByAccountId(Long accountId) {
		TypedQuery<Transaction> query =
			      em.createQuery("SELECT t FROM Transaction t", Transaction.class);
		return query.getResultList();
	}
}
