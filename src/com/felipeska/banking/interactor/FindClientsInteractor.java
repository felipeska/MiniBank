package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinishedLoadClientsListener;

public interface FindClientsInteractor {
    public void findClients(OnFinishedLoadClientsListener listener);
}
