package com.kousik.java8demo.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterfaceExample {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(11,12,15,18,20,24,30);
		List<Integer> list1=Arrays.asList(1,33,24,3);
		int result=0;
		int sum=0;
		for(int i:list) {
			
			if(i%5==0) {
				result+=i;
			}
			sum+=i;
		}
		System.out.println(sum);
		System.out.println(result);
		
		Predicate<Integer> pre=new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t%5==0;
			}
		};
		System.out.println(list.stream()
								.filter(pre)
								.reduce(0,(c,e)->(c+e)));
		System.out.println(list.stream()
							   .filter(i->i%5==0)
							   .findFirst());//Optional[10]
		System.out.println(list.stream()
							   .filter(i->i%5==0)
							   .findFirst()
							   .orElse(0));//10//not give optional
		/*-------------------------------------------------*/
		System.out.println(list1.stream()
								.filter(i->i%5==0)
								.findFirst());//Optional.empty
		System.out.println(list1.stream()
							    .filter(i->i%5==0)
							    .findFirst()
							    .orElse(0));//0
		/*-------------------------------------------------*/
		System.out.println(list.stream().filter(i->i%5==0).reduce(0,(c,e)->(c+e)));
		System.out.println(list.stream().filter(i->i%5==0).reduce(0,Integer::sum));
		
		System.out.println(list.stream()
							   .filter(PredicateInterfaceExample::predicateDivisible)
							   .map(PredicateInterfaceExample::mapDouble)
							   .findFirst()
							   .orElse(0));
		//filter and map are lazy functions.....
		//findfirst is Terminal functions
		//1-findfirst 2.filter 3.map
	}
	
	public static boolean predicateDivisible(int i) {
		System.out.println("in Prediv"+i);
		return i%5==0;
	}
	
	public static int mapDouble(int i) {
		System.out.println("in Mapdouble"+i);
		return i*2;
	}

}
