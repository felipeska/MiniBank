package com.felipeska.banking.presenter;

import com.felipeska.banking.error.Error;
import com.felipeska.banking.interactor.AddAccountInteractor;
import com.felipeska.banking.interactor.AddAccountInteractorImpl;
import com.felipeska.banking.listener.OnSaveAccountListener;
import com.felipeska.banking.view.AccountAddView;

public class AccountAddPresenterImpl implements AccountAddPresenter,
		OnSaveAccountListener {

	private AccountAddView addAccountAddView;
	private AddAccountInteractor addAccountInteractor;

	public AccountAddPresenterImpl(AccountAddView accountAddView) {
		this.addAccountAddView = accountAddView;
		this.addAccountInteractor = new AddAccountInteractorImpl();
	}

	@Override
	public void saveAccount(String number, String clientId, long balance) {
		this.addAccountAddView.showProgress();
		this.addAccountInteractor.onSave(number, clientId, balance, this);
	}

	@Override
	public void onSuccessSave() {
		this.addAccountAddView.hideProgress();
		this.addAccountAddView.saveAccountSuccess();
	}

	@Override
	public void onFailedSave(Error error) {
		this.addAccountAddView.hideProgress();
		this.addAccountAddView.saveAccountError(error);
	}
}
