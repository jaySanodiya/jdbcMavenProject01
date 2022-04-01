package com.masai.app.usecase;

import java.util.Scanner;

import com.masai.app.Exception.EmployeeException;
import com.masai.app.dao.EmployeeDao;
import com.masai.app.dao.EmployeeDaoImpl;

public class GiveBonusToEmployee {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int eid = sc.nextInt();
		
		System.out.println("Enter Amount");
		int salary = sc.nextInt();
		
		
		try {
			String messagee = employeeDao.giveBonusToEmployee(eid, salary);
			System.out.println(messagee);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
