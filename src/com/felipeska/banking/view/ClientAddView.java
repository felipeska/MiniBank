package com.felipeska.banking.view;

import com.felipeska.banking.model.Client;

public interface ClientAddView {
	public void showProgress();
	public void hideProgress();
	public void setClient(Client client);
}
