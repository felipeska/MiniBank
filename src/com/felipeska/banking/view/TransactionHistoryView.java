package com.felipeska.banking.view;

import java.util.List;

import com.felipeska.banking.model.Transaction;

public interface TransactionHistoryView {
	public void showProgress();

	public void hideProgress();

	public void setClients(List<Transaction> transactions);
}
