package com.felipeska.banking.model;

import java.util.List;

import com.codeslap.persistence.PrimaryKey;

public class Account {
	@PrimaryKey()
	private String number;
	private float balance;
	private String client_identification;
	private List<Transaction> transactions;

	public Account() {
	}

	public Account(String number, String client_identification) {
		this(number, client_identification, 0.0f);
	}

	public Account(String number, String client_identification, float balance) {
		this.number = number;
		this.balance = balance;
		this.client_identification = client_identification;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getClient_identification() {
		return client_identification;
	}

	public void setClient_identification(String client_identification) {
		this.client_identification = client_identification;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
