package com.kousik.java8demo.staticmethodinterface;

interface I{
	static void add(int i,int j) {//no need to include default keyword
		System.out.println(i+j);
	}
}
public class Staticmethod {

	public static void main(String[] args) {
		I.add(1, 5);
	}

}
