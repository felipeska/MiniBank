package com.felipeska.banking.view;

import java.util.List;

import com.felipeska.banking.model.Account;

public interface AccountListView {

	public void showProgress();

	public void hideProgress();

	public void setClients(List<Account> accounts);

}
