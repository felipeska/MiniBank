package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinisLoadHistoryTransactionsListener;

public interface FindHistoryTransactionInteractor {
	public void findAccounts(String accountNumber,
			OnFinisLoadHistoryTransactionsListener listener);
}
