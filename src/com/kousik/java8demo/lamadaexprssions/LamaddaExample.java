package com.kousik.java8demo.lamadaexprssions;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface//Optional
//any interface have only one abstract method is have functional interface
interface I{
	void add(int i,int j);
	default void info() {
		System.out.println("This interface is functional interface....");
	}
	//void subtract(int i,int j);//Compiler will throw error because of @FunctionalInterface annotation
}

class A implements I{

	@Override
	public void add(int i, int j) {
		System.out.println(i+j);
	}
	
}
public class LamaddaExample {

	public static void main(String[] args) {
		
		I i =new A();
		i.add(1, 1);
		I i1= (int k,int l)->{
			System.out.println(k+l);
			};
			i1.add(11, 1);
		List<Integer> li=Arrays.asList(1,2,3,5,6);
		
//		for(int in:li) {
//			System.out.println(in);
//		}
		//li.forEach(inn->System.out.println(inn)); //lamada Expressions with internel foreach functions
		li.forEach(System.out::println);			//method reference
	}

}
