package cs544.exercise16_1.bank.dao;

import java.util.*;



import org.hibernate.SessionFactory;

import cs544.exercise16_1.bank.domain.Account;

public class AccountDAO implements IAccountDAO {

	Collection<Account> accountlist = new ArrayList<Account>();

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	
	public void saveAccount(Account account) {

		sf.getCurrentSession().persist(account);
	}
	

	public void updateAccount(Account account) {

		sf.getCurrentSession().saveOrUpdate(account);
	}
	
	

	public Account loadAccount(long accountnumber) {

		return (Account) sf.getCurrentSession().get(Account.class, accountnumber);
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Account> getAccounts() {
		return sf.getCurrentSession().createQuery("from Account").list();
	}

	
	
}
