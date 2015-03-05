package com.felipeska.banking.listener;

import java.util.List;

import com.felipeska.banking.model.Transaction;

public interface OnFinisLoadHistoryTransactionsListener {
	public void onFinished(List<Transaction> items);
}
