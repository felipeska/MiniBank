package com.felipeska.banking.view;

import com.felipeska.banking.model.Client;

public interface ClientView {

	public void showProgress();

	public void hideProgress();

	public void setClient(Client client);
}
