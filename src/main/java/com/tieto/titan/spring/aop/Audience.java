package com.tieto.titan.spring.aop;

public class Audience {
	//Before perform
	public void takeSeats() {
		System.out.println("The audience is taking their seats. ");
	}
	
	//Before perform
	public void turnoffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}
	
	//Performer perform successful
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP ..");
	}
	
	//If the performer failed
	public void demandRefound() {
		System.out.println("Boo! we want our money back");
	}

}
