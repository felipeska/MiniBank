package com.felipeska.banking.presenter;

import java.util.List;

import com.felipeska.banking.interactor.FindAccountsInteractor;
import com.felipeska.banking.interactor.FindAccountsInteractorImpl;
import com.felipeska.banking.listener.OnFinishedLoadAccountsListener;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.view.AccountListView;

public class AccountListPresenterImpl implements AccountListPresenter,
		OnFinishedLoadAccountsListener {

	private AccountListView accountListView;
	private FindAccountsInteractor findAccountsInteractor;

	public AccountListPresenterImpl(AccountListView accountListView) {
		this.accountListView = accountListView;
		this.findAccountsInteractor = new FindAccountsInteractorImpl();
	}

	@Override
	public void onResume() {
		this.accountListView.showProgress();
		this.findAccountsInteractor.findAccounts(this);
	}

	@Override
	public void onFinished(List<Account> items) {
		this.accountListView.hideProgress();
		this.accountListView.setClients(items);
	}

}
