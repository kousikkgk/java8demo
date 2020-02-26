package com.kousik.java8demo.defaultinterface;

interface I{
	void add();
	default void summary() {
		System.out.println("Interface I Summary.....");
	}
}

interface J{
	void add();
	default void summary() {
		System.out.println("Interface J Summary.....");
	}
}

class K{
	
	public void summary() {
		System.out.println("Class K Summary....");
	}
}

class L extends K implements I{

	@Override
	public void add() {
		System.out.println("Add Class L  ....");
	}
	
}

public class InterfacevsClass {

	public static void main(String[] args) {
		I i=new L();
		i.add();
		i.summary();//Class K method only called not interface
		//Class has more power than Interface....
	}

}
