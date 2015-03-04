package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinishedLoadAccountsListener;

public interface FindAccountsInteractor {
	public void findAccounts(String clientId,
			OnFinishedLoadAccountsListener listener);
}
