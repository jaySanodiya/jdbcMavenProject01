package com.masai.app.usecase;

import java.util.Scanner;

import com.masai.app.Exception.EmployeeException;
import com.masai.app.dao.EmployeeDao;
import com.masai.app.dao.EmployeeDaoImpl;

public class DeleteEmployeeById {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		
		
		try {
			boolean workDone = employeeDao.deleteEmployeeById(sc.nextInt());
			
			if( workDone==true) System.out.println("Row is deleted...");
			else System.out.println("Employee Id not matches data...");
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
