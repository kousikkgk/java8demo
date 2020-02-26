package com.kousik.java8demo.defaultinterface;

interface Actor{
	void dance();
	void act();
	void takeBreak();
	default void comedy() {
		System.out.println("Actor will make comedies....");
	}
}

interface Dancer{
	void dance();
	default void comedy() {
		System.out.println("Dancer will make comedies....");
	}
}

class Hero implements Actor,Dancer{

	@Override
	public void dance() {
		System.out.println("Hero will dance ");
	}

	@Override
	public void act() {
		System.out.println("Hero will act");
	}

	@Override
	public void comedy() {
		Actor.super.comedy();//Actor interface default method
	}
//	@Override
//	public void comedy() {
//		Dancer.super.comedy();//we can't override both interface default methods.....
//	}
	public void takeBreak() {
		System.out.println("Hero Take Break");
	}
}
public class DefaultInterfaceMain {

	public static void main(String[] args) {
		Actor actor=new Hero();
		actor.act();//nothing 
		actor.dance();
		actor.comedy();
		
	}

}
