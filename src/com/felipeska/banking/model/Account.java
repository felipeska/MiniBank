package com.felipeska.banking.model;

import java.util.List;

import com.codeslap.persistence.PrimaryKey;

public class Account {
	@PrimaryKey()
	private String number;
	private float balance;
	private int status = Status.ACTIVE.status;
	private String client_identification;
	private List<Transaction> transactions;

	public Account() {
	}

	public Account(String number, String client_identification) {
		this(number, client_identification, 0.0f, 1);
	}

	public Account(String number, String client_identification,
			float balanceDebit, int status) {
		this.number = number;
		this.balance = balanceDebit;
		this.client_identification = client_identification;
		this.status = status;
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

	public void setBalance(float balanceDebit) {
		this.balance = balanceDebit;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public enum Status {
		ACTIVE(1), INACTIVE(0);

		private final int status;

		private Status(int status) {
			this.status = status;
		}

		public static Status getStatus(int status) {
			for (Status t : Status.values()) {
				if (status == t.getValue())
					return t;
			}
			return ACTIVE;
		}

		private int getValue() {
			return this.status;
		}
	}
}
