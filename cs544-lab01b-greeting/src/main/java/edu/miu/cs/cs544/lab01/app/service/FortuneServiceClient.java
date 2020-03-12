package edu.miu.cs.cs544.lab01.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs.cs544.lab01.app.domain.Fortune;

@Service
public class FortuneServiceClient implements FortuneService {

	@Autowired
	private RestTemplate restTemplate;
	
	  @Value("${fortuneService.baseUrl}")
	  private String baseUrl;

	@Override
	public Fortune getFortune() {
		return restTemplate.getForObject(baseUrl, Fortune.class);
	}

}
