package com.project.HibernateConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.BankAccount;
import com.project.entity.Customer;

public class TestClient {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		// CustomerServiceDAO csd = new CustomerServiceDAOImpl();
		// BankAccountServiceDAO bsd = new BankAccountServiceDAOImpl();
		//
		HibernateConfig config = new HibernateConfig();

		Session session = config.getSessionFactory().openSession();

		// BankAccount bankAccount = new BankAccount();
		// bankAccount.setBankBalance(5000);
		// Transaction transaction = session.beginTransaction();
		// session.save(bankAccount);
		// bankAccount.setBankAccountNumber(1);
		// bsd.addBankAccount(bankAccount);
		// Customer customer = new Customer();
		// customer.setFirstName("scott");
		// customer.setLastName("urman");
		// customer.setUsername("scott");
		// customer.setPassword("tiger");
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		// java.util.Date tempdate = sdf.parse("23/09/17");
		// java.sql.Date dob = new java.sql.Date(tempdate.getTime());
		// customer.setDob(dob);
		// customer.setBankAccount(bankAccount);
		// session.save(customer);
		// transaction.commit();
		System.out.println("Added");

		Query query = session.createQuery("from Customer");

		List<Customer> customers = query.list();

		System.out.println(customers.size());

		for (Customer customer2 : customers) {
			System.out.println(customer2.getCustomerId() + " " + customer2.getBankAccount());
		}

		session.close();
		// csd.addCustomer(customer);

		// Customer customer = csd.getCustomerById(2);
		// System.out.println(customer.getBankAccount().getBankAccountNumber());

	}

}
