package com.felipeska.banking.interactor;

import java.util.List;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.listener.OnFinishedLoadAccountsListener;
import com.felipeska.banking.model.Account;

public class FindAccountsInteractorImpl implements FindAccountsInteractor {

	@Override
	public void findAccounts(String clientID,
			OnFinishedLoadAccountsListener listener) {
		listener.onFinished(getAccounts(clientID));
	}

	private List<Account> getAccounts(String ClientId) {
		Account accountMatch = new Account();
		accountMatch.setClient_identification(ClientId);
		return DatabaseHelper.load().findAll(accountMatch);
	}

}
