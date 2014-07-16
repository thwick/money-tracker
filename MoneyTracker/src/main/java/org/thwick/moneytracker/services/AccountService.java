package org.thwick.moneytracker.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thwick.moneytracker.dao.AccountDAO;
import org.thwick.moneytracker.dao.TransactionDAO;
import org.thwick.moneytracker.models.Account;
import org.thwick.moneytracker.models.Transaction;

@Service
public class AccountService {

	@Inject
	private AccountDAO accountDAO;
	
	@Inject
	private TransactionDAO transactionDAO;
	
	public AccountService()
	{
		
	}
	
	@Transactional
	public Account newAccount(Account account) {
		return accountDAO.create(account);
	}
	
	@Transactional
	public Account update(Account account) {
		return accountDAO.update(account);
	}
	
	@Transactional
	public List<Account> findAll() {
		return accountDAO.findAll();
	}
	
	@Transactional
	public Account find(Long accountId) {
		return accountDAO.find(accountId);
	}
	
	@Transactional
	public List<Transaction> findAccountTransactions(Long accountId) {
		return transactionDAO.findByAccountId(accountId);
	}
	
	@Transactional
	public void delete(List<Long> accountIds) {
		accountDAO.delete(accountIds);
	}
	
	@Transactional
	public void delete(Long accountId) {
		accountDAO.delete(accountId);
	}
	
	@Transactional
	public Transaction updateAccountTransaction(Transaction transaction) {
		return transactionDAO.update(transaction);
	}
}
