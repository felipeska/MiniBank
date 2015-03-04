package com.felipeska.banking.model;

import java.util.List;

import com.codeslap.persistence.PrimaryKey;

public class Client {

	private String name;
	@PrimaryKey()
	private String identification;
	private String address;
	private String phone;
	private List<Account> accounts;

	public Client() {
	}

	public Client(String name, String id) {
		this(name, id, null, null);
	}

	public Client(String name, String identification, String address,
			String phone) {
		this.name = name;
		this.identification = identification;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public int totalAccounts() {
		return this.accounts.size();
	}

	public boolean hasAccounts() {
		return (this.accounts.size() > 0 ? true : false);
	}
}
