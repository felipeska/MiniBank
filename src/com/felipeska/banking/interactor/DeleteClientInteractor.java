package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnDeleteClientListener;
import com.felipeska.banking.model.Client;

public interface DeleteClientInteractor {
	public void delete(Client client, OnDeleteClientListener listener);

}
