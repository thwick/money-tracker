package org.thwick.moneytracker.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thwick.moneytracker.dao.TransactionDAO;
import org.thwick.moneytracker.models.Transaction;

@Service
public class TransactionService {

	@Inject
	private TransactionDAO transactionDAO;
	
	public TransactionService() {
		
	}
	
	@Transactional
	public Transaction updateAccountTransaction(Transaction transaction) {
		return transactionDAO.update(transaction);
	}
}
