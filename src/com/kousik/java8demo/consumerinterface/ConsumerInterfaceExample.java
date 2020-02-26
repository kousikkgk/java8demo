package com.kousik.java8demo.consumerinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {

	public static void main(String[] args) {
		
		List<Integer> li=Arrays.asList(1,2,3,5,6);
		
		//Implementing Consumer interface with class
		/*
		ConsumerImpl impl=new ConsumerImpl();
		impl.accept(11);
		li.forEach(impl);
		*/
		//Anonymous class for Consumer Interface
		/*
		Consumer<Integer> cons=new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		};
		li.forEach(cons);
		*/
		
		Consumer<Integer> conslam1=(Integer i)->{System.out.println(i);};//Lamada Expression
		Consumer<Integer> conslam2=i->System.out.println(i);//Lamada Expression
		li.forEach(new Consumer<Integer>() {/*Boiler Plate code*/
			@Override						/*|*/						
			public void accept(Integer t) { /*|*/
				System.out.println(t);		/*|*/
			}/*-------------------------------|-*/
		});
		li.forEach(conslam1);
		li.forEach(conslam2);
		li.forEach(System.out::println);
	}

}
class ConsumerImpl implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println(t);
	}
	
}
