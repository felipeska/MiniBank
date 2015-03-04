package com.felipeska.banking.presenter;

import com.felipeska.banking.model.Transaction.TransactionType;

public interface TransactionPresenter {
	public void transation(String accountNumber, long balance,
			long transactionValue, TransactionType transactionType);
}
