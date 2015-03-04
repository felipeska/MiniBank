package com.felipeska.banking.interactor;

import java.util.List;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.listener.OnFinishedLoadAccountsListener;
import com.felipeska.banking.model.Account;

public class FindAccountsInteractorImpl implements FindAccountsInteractor {

	@Override
	public void findAccounts(OnFinishedLoadAccountsListener listener) {
		listener.onFinished(getAccounts());
	}

	private List<Account> getAccounts() {
		return DatabaseHelper.load().findAll(Account.class);
	}

}
