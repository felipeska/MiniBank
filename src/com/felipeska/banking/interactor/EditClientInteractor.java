package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnEditClientListener;
import com.felipeska.banking.model.Client;

public interface EditClientInteractor {
	public void edit(Client oldClient, Client newClient,
			OnEditClientListener listener);
}
