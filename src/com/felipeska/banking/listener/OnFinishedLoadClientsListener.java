package com.felipeska.banking.listener;

import java.util.List;

import com.felipeska.banking.model.Client;

public interface OnFinishedLoadClientsListener {
	public void onFinished(List<Client> items);
}
