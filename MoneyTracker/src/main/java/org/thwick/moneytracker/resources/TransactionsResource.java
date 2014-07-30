package org.thwick.moneytracker.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.thwick.moneytracker.models.Transaction;
import org.thwick.moneytracker.services.TransactionService;

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class TransactionsResource {

	@Inject private TransactionService transactionService;
	
	@GET
	public Transaction[] listTransactions() {
		List<Transaction> transactions = transactionService.findAll();
		
		return transactions.toArray(new Transaction[0]);
	}
	
	@POST  
	public Transaction update(Transaction transaction) {
		return transactionService.updateAccountTransaction(transaction);
	}
}
