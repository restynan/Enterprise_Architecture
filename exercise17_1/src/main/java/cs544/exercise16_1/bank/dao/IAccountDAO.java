package cs544.exercise16_1.bank.dao;

import java.util.Collection;
import java.util.List;

import cs544.exercise16_1.bank.domain.Account;



public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public List<Account> getAccounts();
}
