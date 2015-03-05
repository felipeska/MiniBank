package com.felipeska.banking.interactor;

import java.util.List;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.listener.OnFinisLoadHistoryTransactionsListener;
import com.felipeska.banking.model.Transaction;

public class FindHistoryTransactionInteractorImpl implements
		FindHistoryTransactionInteractor {

	@Override
	public void findAccounts(String accountNumber,
			OnFinisLoadHistoryTransactionsListener listener) {
		listener.onFinished(findTransactions(accountNumber));
	}

	private List<Transaction> findTransactions(String accountNumber) {
		Transaction transactionMatch = new Transaction();
		transactionMatch.setAccount_number(accountNumber);
		return DatabaseHelper.load().findAll(transactionMatch);
	}
}
