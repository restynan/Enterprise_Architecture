package cs544.exercise12_1.bank.logging;

import org.springframework.stereotype.Component;


public class Logger implements ILogger{
	public Logger(){}
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
