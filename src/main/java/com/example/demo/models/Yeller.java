package com.example.demo.models;

public class Yeller {
	String msg;
	
	public Yeller(String message) {
		msg = message;
	}

	public String repeatWhatISayButLouder() {
		return msg.toUpperCase();
	}
}
