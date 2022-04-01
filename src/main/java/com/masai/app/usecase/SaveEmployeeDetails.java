package com.masai.app.usecase;

import java.util.Scanner;

import com.masai.app.bean.Employee;
import com.masai.app.dao.EmployeeDao;
import com.masai.app.dao.EmployeeDaoImpl;

public class SaveEmployeeDetails {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		
		System.out.println("Enter employee name");
		String name = sc.next();
		
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		
		
		String message = employeeDao.saveEmployeeDetails(new Employee(id,name,salary));
				
				System.out.println(message);

	}

}
