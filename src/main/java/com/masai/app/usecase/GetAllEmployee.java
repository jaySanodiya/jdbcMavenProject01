package com.masai.app.usecase;

import java.util.List;
import com.masai.app.bean.Employee;
import com.masai.app.dao.EmployeeDao;
import com.masai.app.dao.EmployeeDaoImpl;

public class GetAllEmployee {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		
			List<Employee> list = employeeDao.getAllEmployee();
		
			list.stream().forEach(s-> {
				System.out.println("Employee Id is : " + s.getEmpId());
				System.out.println("Employee name is : " + s.getName());
				System.out.println("Employee salary is : " + s.getSalary());
			});
	}

}
