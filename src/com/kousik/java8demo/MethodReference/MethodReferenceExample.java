package com.kousik.java8demo.MethodReference;

import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;
public class MethodReferenceExample {

	public static void main(String[] args) {
		List<Integer> li=Arrays.asList(1,2,3,4,5);
		Consumer<Integer> intg=i->System.out.println(i);;
		//li.forEach(intg);
		
		li.forEach(System.out::println);//Method Reference
		//Call by method
		
		//li.forEach(i->doubleIt(i));
		li.forEach(MethodReferenceExample::doubleIt);
	}
	public static void doubleIt(int i) {
		System.out.println(i*2);
	}

}
