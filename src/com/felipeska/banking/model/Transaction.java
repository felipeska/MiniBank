package com.felipeska.banking.model;

public class Transaction {
	private long id;
	private int transactionType = TransactionType.DEBIT.type;
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

	public TransactionType transactionType() {
		return TransactionType.getTransactionType(transactionType);
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

	public boolean havePositiveBalance(long balance, long credit) {
		return (balance - credit > 0) ? true : false;
	}

	public enum TransactionType {
		DEBIT(0), CREDIT(1);

		private final int type;

		TransactionType(int type) {
			this.type = type;
		}

		public static TransactionType getTransactionType(int type) {
			for (TransactionType t : TransactionType.values()) {
				if (type == t.getValue())
					return t;
			}
			return DEBIT;
		}

		public int getValue() {
			return type;
		}
	}

}
