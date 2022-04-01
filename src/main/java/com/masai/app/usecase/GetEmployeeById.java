package com.masai.app.usecase;

import java.util.Scanner;

import com.masai.app.Exception.EmployeeException;
import com.masai.app.bean.Employee;
import com.masai.app.dao.EmployeeDao;
import com.masai.app.dao.EmployeeDaoImpl;

public class GetEmployeeById {

	public static void main(String[] args) {
	
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		System.out.println("Enter employee Id");
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Employee employee = employeeDao.getEmployeeById(sc.nextInt());
			
			System.out.println("Employee Id is :"+ employee.getEmpId());
			System.out.println("Employee Name is :" + employee.getName());
			System.out.println("Employee Salary is :"+ employee.getSalary());
			
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
