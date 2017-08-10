package com.example.demo.models;

public class Whisperer {
	
	String msg;
	
	public Whisperer(String message) {
		msg = message;
	}
	
	public String quiet() {
		String result = msg.toLowerCase();
		return result;
	}

}
