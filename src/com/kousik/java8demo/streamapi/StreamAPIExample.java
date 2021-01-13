package com.kousik.java8demo.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamAPIExample {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,3,5,7,9);
		
		int result=0;
		int sum=0;
		for(int i:list) {
			result=result+i*2;
			sum=sum+i;
		}
	/*	System.out.println(result);
		System.out.println(sum);
		System.out.println(list.stream().map(i->i*2).reduce(0,(c,e)->c+e));*/
		
		Function<Integer,Integer> fn=new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t*2;
			}
			
		};
		
		BinaryOperator<Integer> bi=new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}
		};
		Stream<Integer> s=list.stream();
		Stream<Integer> s1=s.map(fn);//function interface will return the doubled value
		Integer s2=(Integer)s1.reduce(0,bi);//Binaray Operater interface will return the added value
		//s1.forEach(System.out::println);
		//System.out.println(s2);/*System.out.println(list.stream().map(i->i*2).reduce(0,(c,e)->c+e));*///Same
		System.out.println(list.stream().map(i->i*2).reduce(0,(c,e)->Integer.sum(c, e)));
		System.out.println(list.stream().map(i->i*2).reduce(0,Integer::sum));
	}
}
