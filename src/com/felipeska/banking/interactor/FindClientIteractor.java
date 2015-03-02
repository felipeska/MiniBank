package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinishedLoadClientListener;



public interface FindClientIteractor {
	public void findClient(String clientId, OnFinishedLoadClientListener listener);
}
