package com.masai.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.app.Exception.EmployeeException;
import com.masai.app.bean.Employee;
import com.masai.app.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
			
		Employee employee = null;

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement statement = conn.prepareStatement("select * from employee where empId = ?");
			
			statement.setInt(1, empId);
			
			ResultSet result = statement.executeQuery();
			
			result.next();
			
			employee = new Employee(result.getInt("empId"),result.getString("name"),result.getInt("salary"));
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement statement2 = conn.prepareStatement("select * from employee");
			
			ResultSet result2 = statement2.executeQuery();
			
			list = new ArrayList<>();
			
			while(result2.next()) {
				list.add(new Employee(result2.getInt("empId"),result2.getString("name"),result2.getInt("salary")));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public String saveEmployeeDetails(Employee employee) {
		
		String message = "Not saved....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement statement3 = conn.prepareStatement("insert into employee values(?,?,?)");
			statement3.setInt(1, employee.getEmpId());
			statement3.setString(2, employee.getName());
			statement3.setInt(3, employee.getSalary());
			
			int numbers = statement3.executeUpdate();
			if(numbers>0)message = "Data inserted sucessfully....";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return message;
	}

	@Override
	public boolean deleteEmployeeById(int empId) throws EmployeeException {
			boolean workDone = false;
			
			try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement statement4 = conn.prepareStatement("delete from employee where empId = ?");
				statement4.setInt(1, empId);
				
				int numbers = statement4.executeUpdate();
				
				if(numbers>0)workDone = true;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			

			
			
			
		return workDone;
	}

	@Override
	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		String message = "Bonus is not given....";
		
		try (Connection conn = DBUtil.provideConnection() ){
			
			PreparedStatement statement5 = conn.prepareStatement(" update employee set salary = salary + ? where empId = ?;");
			statement5.setInt(2, empId);
			statement5.setInt(1, amount);
			
			int result5 = statement5.executeUpdate();
			
			if(result5>0)message="salary updated....";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return message;
	}

}










