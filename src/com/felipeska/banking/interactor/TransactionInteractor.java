package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnTransactionListener;
import com.felipeska.banking.model.Transaction.TransactionType;

public interface TransactionInteractor {
	public void transation(String accountNumber, long balance,
			long transactionValue, TransactionType transactionType,
			OnTransactionListener listener);
}
