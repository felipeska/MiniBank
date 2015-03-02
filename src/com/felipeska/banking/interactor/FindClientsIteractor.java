package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnFinishedLoadClientsListener;

public interface FindClientsIteractor {
    public void findClients(OnFinishedLoadClientsListener listener);
}
