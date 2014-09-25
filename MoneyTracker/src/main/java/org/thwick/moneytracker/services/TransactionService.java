package org.thwick.moneytracker.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thwick.moneytracker.dao.TransactionDAO;
import org.thwick.moneytracker.models.Account;
import org.thwick.moneytracker.models.Category;
import org.thwick.moneytracker.models.Transaction;

@Service
public class TransactionService {

	@Inject
	private TransactionDAO transactionDAO;
	
	public TransactionService() {
		
	}
	
	@Transactional
	public List<Transaction> findByAccountId(Long accountId) {    
		return transactionDAO.findByAccountId(accountId);
	}
	
	@Transactional
	public List<Transaction> findAll() {    
		return transactionDAO.findAll();
	}
	
	@Transactional
	public Transaction updateAccountTransaction(Transaction transaction) {
		
		// handle transactions direct from Rest resources
		if (transaction.getAccountId() != null && transaction.getAccount() == null) {
			Account account = new Account();
			account.setId(transaction.getAccountId());
			transaction.setAccount(account);
		}
		
		if (transaction.getCategory() == null && transaction.getCategoryId() != null) {
			Category category = new Category();
			category.setId(transaction.getCategoryId());
			transaction.setCategory(category);
		}
		
		return transactionDAO.update(transaction);
	}
}
