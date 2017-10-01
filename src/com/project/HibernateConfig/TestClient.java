package com.project.HibernateConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.project.daoimpl.BankAccountDAOImpl;
import com.project.daoimpl.CustomerDAOImpl;
import com.project.entity.BankAccount;
import com.project.entity.Customer;

public class TestClient {

	// Declaring variables
	static BankAccountDAOImpl bankAccountDAO = null;
	static CustomerDAOImpl customerDAO = null;

	// Initializing variables
	public TestClient() {
		bankAccountDAO = new BankAccountDAOImpl();
		customerDAO = new CustomerDAOImpl();
	}

	// main method
	public static void main(String[] args) throws ParseException {

		// calling constructor to initialize declared variable,
		// we can skip this by removing the constructor
		new TestClient();

		// Method add details in the database
		// addBankAccountDetails();

		// Method to delete details
		// deleteBankAccountDetails(17);

		// Method to edit details
		// updateBankAccountDetails();

		// creating list
		List<Customer> customers = customerDAO.getAll();

		// display the data
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
	}

	private static boolean addBankAccountDetails() {
		try {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setBankBalance(5000);
			bankAccountDAO.add(bankAccount);
			Customer customer = new Customer();
			customer.setFirstName("scott");
			customer.setLastName("urman");
			customer.setUsername("scott");
			customer.setPassword("tiger");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			java.util.Date tempdate = sdf.parse("23/09/17");
			java.sql.Date dob = new java.sql.Date(tempdate.getTime());
			customer.setDob(dob);
			customer.setBankAccount(bankAccount);
			customerDAO.add(customer);
			System.out.println("Add Successfully!");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static boolean updateBankAccountDetails() {
		try {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setBankBalance(5000);
			bankAccountDAO.add(bankAccount);
			Customer customer = new Customer();
			customer.setFirstName("scott");
			customer.setLastName("urman");
			customer.setUsername("scott");
			customer.setPassword("tiger");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			java.util.Date tempdate = sdf.parse("23/09/17");
			java.sql.Date dob = new java.sql.Date(tempdate.getTime());
			customer.setDob(dob);
			customer.setBankAccount(bankAccount);
			customerDAO.add(customer);
			System.out.println("Edited Successfully!");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static boolean deleteBankAccountDetails(int id) {
		try {
			Customer customerr = customerDAO.get(17);
			customerDAO.delete(customerr);
			System.out.println("Deleted Successfully!");
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
