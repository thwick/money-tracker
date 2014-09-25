package org.thwick.moneytracker.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import org.thwick.moneytracker.models.AccountBalance;
import org.thwick.moneytracker.models.Transaction;

public class TransactionDAO extends AbstractDAO<Transaction> {

	public TransactionDAO() {
		super();
	}
	
	public List<Transaction> findByAccountId(Long accountId) {
		TypedQuery<Transaction> query =
			      em.createQuery("SELECT t FROM Transaction t  WHERE account_id = :accountId", Transaction.class);
		query.setParameter("accountId", accountId);
		
		return query.getResultList();
	}
	
	public AccountBalance getAccountBalance(Long accountId) {
		TypedQuery<BigDecimal> query = em.createQuery("SELECT SUM(amount) FROM Transaction t WHERE account_id = :accountId", BigDecimal.class);
		query.setParameter("accountId", accountId);
		BigDecimal result = query.getSingleResult();
		
		AccountBalance balance = new AccountBalance();
		balance.setAccountId(accountId);
		if (result != null) {
			balance.setBalance(result.doubleValue());
		}
		return balance;
	}
}
