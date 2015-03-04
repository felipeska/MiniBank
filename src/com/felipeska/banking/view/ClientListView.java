package com.felipeska.banking.view;

import java.util.List;

import com.felipeska.banking.model.Client;

public interface ClientListView {
	
	public void showProgress();
	public void hideProgress();
	public void setClients(List<Client> clients);
}
