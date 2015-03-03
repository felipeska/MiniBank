package com.felipeska.banking.model;

public class Transaction {
	private long id;
	private int transactionType;
	private long date;
	private float value;
	private String account_number;

	public Transaction() {
	}

	public Transaction(int transtactionType, long date, float value,
			String account_number) {
		this.transactionType = transtactionType;
		this.date = date;
		this.value = value;
		this.account_number = account_number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

}
