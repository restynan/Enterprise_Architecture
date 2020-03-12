package edu.miu.cs.cs544.lab01.app.domain;

public class Greeting {
	private String text;
	
	private Fortune fortune;

	public Greeting(String text, Fortune fortune) {
		super();
		this.text = text;
		this.fortune = fortune;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Fortune getFortune() {
		return fortune;
	}

	public void setFortune(Fortune fortune) {
		this.fortune = fortune;
	}
}
