package com.tieto.titan.spring.ioc.impl;

public class PoeticJuggler   extends Juggler{
	private Poem poem; 
	public PoeticJuggler(int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}
	
	public PoeticJuggler(Poem poem) {
		this.poem = poem;
	}
	
	@Override
	public void perform() {
		super.perform();
		System.out.println("While reciting ......");
		poem.recite();
	}
	
}
