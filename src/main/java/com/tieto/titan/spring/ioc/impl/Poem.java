package com.tieto.titan.spring.ioc.impl;

public class Poem {
	private static String[] lines = {
		"aaaaaaaaaaaaaaaaaaaaaaa",
		"bbbbbbbbbbbbbb",
		"ccccccccccccccccc",
		"ddddddddddddddddd"
	};
	
	public Poem () {
		
	}
	
	public Poem(String[] lines) {
		Poem.lines = lines;
	}
	
	public void recite() {
		for (String s : lines){
			System.out.println(s);
		}
	}
	
}
