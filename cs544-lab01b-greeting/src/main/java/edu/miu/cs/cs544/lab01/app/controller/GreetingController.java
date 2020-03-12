package edu.miu.cs.cs544.lab01.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.lab01.app.domain.Greeting;
import edu.miu.cs.cs544.lab01.app.service.FortuneService;

@RestController
public class GreetingController {
	
	@Autowired
	private FortuneService fortuneService;
	
	@GetMapping
	public Greeting getGreeting() {
		return new Greeting("Welcome!", fortuneService.getFortune());
	}
	
	@GetMapping("/check")
	public String dummy() {
		return "checking";
	}

}