package cs544.exercise12_1.bank.jms;

import org.springframework.stereotype.Component;


public class JMSSender implements IJMSSender{
	public JMSSender(){}
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
