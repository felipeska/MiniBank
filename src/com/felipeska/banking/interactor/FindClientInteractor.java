package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinishedLoadClientListener;



public interface FindClientInteractor {
	public void findClient(String clientId, OnFinishedLoadClientListener listener);
}
