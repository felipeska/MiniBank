package com.felipeska.banking.listener;

import com.felipeska.banking.model.Client;

public interface OnFinishedLoadClientListener {
	void onFinished(Client client);
}
