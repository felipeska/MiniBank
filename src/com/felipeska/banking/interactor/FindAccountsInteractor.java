package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinishedLoadAccountsListener;

public interface FindAccountsInteractor {
	public void findAccounts(OnFinishedLoadAccountsListener listener);
}
