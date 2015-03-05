package com.felipeska.banking.presenter;

import com.felipeska.banking.error.Error;
import com.felipeska.banking.interactor.TransactionInteractor;
import com.felipeska.banking.interactor.TransactionInteractorImpl;
import com.felipeska.banking.listener.OnTransactionListener;
import com.felipeska.banking.model.Transaction.TransactionType;
import com.felipeska.banking.view.TransactionView;

public class TransactionPresenterImpl implements TransactionPresenter,
		OnTransactionListener {

	private TransactionView transactionView;
	private TransactionInteractor transactionInteractor;

	public TransactionPresenterImpl(TransactionView transactionView) {
		this.transactionView = transactionView;
		this.transactionInteractor = new TransactionInteractorImpl();
	}

	@Override
	public void transation(String accountNumber, long balance,
			long transactionValue, TransactionType transactionType) {
		transactionInteractor.transation(accountNumber, balance,
				transactionValue, transactionType, this);
	}

	@Override
	public void onSuccessTransaction() {
		transactionView.hideProgress();
		transactionView.transactionSuccess();
	}

	@Override
	public void onFailedTransaction(Error error) {
		transactionView.hideProgress();
		transactionView.transactionError(error);
	}

}
