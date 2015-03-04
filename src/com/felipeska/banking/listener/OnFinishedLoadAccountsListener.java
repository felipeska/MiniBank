package com.felipeska.banking.listener;

import java.util.List;

import com.felipeska.banking.model.Account;

public interface OnFinishedLoadAccountsListener {
	public void onFinished(List<Account> items);
}
