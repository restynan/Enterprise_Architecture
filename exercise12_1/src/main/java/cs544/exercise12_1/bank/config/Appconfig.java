package cs544.exercise12_1.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs544.exercise12_1.bank.dao.AccountDAO;
import cs544.exercise12_1.bank.dao.IAccountDAO;
import cs544.exercise12_1.bank.jms.IJMSSender;
import cs544.exercise12_1.bank.jms.JMSSender;
import cs544.exercise12_1.bank.logging.ILogger;
import cs544.exercise12_1.bank.logging.Logger;
import cs544.exercise12_1.bank.service.AccountService;
import cs544.exercise12_1.bank.service.CurrencyConverter;
import cs544.exercise12_1.bank.service.IAccountService;
import cs544.exercise12_1.bank.service.ICurrencyConverter;

@Configuration
public class Appconfig {
@Bean
	public AccountService getAccountService() {
		return new AccountService() ;
	}
@Bean
public AccountDAO getAccountDAO(){
	return new AccountDAO();
	
}
@Bean
public CurrencyConverter getCurrencyConverter() {
	return new CurrencyConverter();
}
@Bean
public JMSSender getJmsSender() {
	return new JMSSender();
}

@Bean
public Logger logger() {
	return new Logger(); 
}

}
