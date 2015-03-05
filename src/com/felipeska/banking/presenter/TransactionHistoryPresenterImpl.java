package com.felipeska.banking.presenter;

import java.util.List;

import com.felipeska.banking.interactor.FindHistoryTransactionInteractor;
import com.felipeska.banking.interactor.FindHistoryTransactionInteractorImpl;
import com.felipeska.banking.listener.OnFinisLoadHistoryTransactionsListener;
import com.felipeska.banking.model.Transaction;
import com.felipeska.banking.view.TransactionHistoryView;

public class TransactionHistoryPresenterImpl implements
		TransactionHistoryPresenter, OnFinisLoadHistoryTransactionsListener {
	private TransactionHistoryView transactionHistoryView;
	private FindHistoryTransactionInteractor findHistoryTransactionInteractor;

	public TransactionHistoryPresenterImpl(
			TransactionHistoryView transactionHistoryView) {
		this.transactionHistoryView = transactionHistoryView;
		this.findHistoryTransactionInteractor = new FindHistoryTransactionInteractorImpl();
	}

	@Override
	public void findHistory(String accountNumber) {
		this.transactionHistoryView.showProgress();
		this.findHistoryTransactionInteractor.findAccounts(accountNumber, this);
	}

	@Override
	public void onFinished(List<Transaction> items) {
		this.transactionHistoryView.hideProgress();
		this.transactionHistoryView.setClients(items);
	}

}
