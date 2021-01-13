package com.kousik.java8demo.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import com.kousik.java8demo.model.Employee;

public class EmployeeFilterExample {

	public static void main(String[] args) {

		List<Employee> emp=new ArrayList<Employee>();
		
		Employee e1=new Employee("Kousik", 27);
		Employee e2=new Employee("Daniel", 25);
		Employee e3=new Employee("sesha", 23);
		
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		
		//Given a list of employees, you need to filter all the employee whose age is greater than 20 and print the employee names
		List<String> empStr = emp.stream()
					   .filter(e->e.getAge()<20)
					   .map(Employee::getName)
					   .collect(Collectors.toList());
		empStr.forEach(System.out::println);
		
		//Given the list of employees, count number of employees with age 25
		
		long count = emp.stream()
						.filter(e->e.getAge()>25)
						.count();
		System.out.println(count);
		
		//Given the list of employees, find the employee with name “Sesha”.
		
		Optional<Employee> empname = emp.stream()
										.filter(e->e.getName()
										.equalsIgnoreCase("rko"))
										.findAny();
		if(empname.isPresent())// java.util.NoSuchElementException
			System.out.println(empname.get());
		System.out.println(empname);//optional empty
		
		//Given a list of employee, find maximum age of employee
		OptionalInt max = emp.stream().mapToInt(Employee::getAge).max();
		System.out.println(max.getAsInt());
		
		//Given a list of employees, sort all the employee on the basis of age? 
		emp.sort((ep1,ep2)->ep1.getAge()-ep2.getAge());
		emp.forEach(System.out::println);
		
		//Join the all employee names with “,” using java 8
		List<String> empNames = emp.stream()
		.map(Employee::getName)
		.collect(Collectors.toList());
		String str=String.join(",", empNames);
		System.out.println(str);
		
		//Given the list of employee, group them by employee name?
		Map<String, List<Employee>> map = emp.stream()
		.collect(Collectors.groupingBy(Employee::getName));
		map.forEach((name,emp1)->System.out.println(name+"--"+emp1));
	}

}
