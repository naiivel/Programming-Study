package net.koreate.di.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	
	@Override
	public void testService(String message) {
		System.out.println(message + " : test service");
	}
}
