package com.project.entity;

public class BankAccount {
	
	private int bankAccountNumber;
	private double bankBalance;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(double bankBalance) {
		super();
		this.bankBalance = bankBalance;
	}

	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	@Override
	public String toString() {
		return "BankAccount [bankAccountNumber=" + bankAccountNumber + ", bankBalance=" + bankBalance + "]";
	}
	
}
