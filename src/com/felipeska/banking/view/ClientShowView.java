package com.felipeska.banking.view;

import com.felipeska.banking.model.Client;

public interface ClientShowView {

	public void showProgress();

	public void hideProgress();

	public void setClient(Client client);
}
