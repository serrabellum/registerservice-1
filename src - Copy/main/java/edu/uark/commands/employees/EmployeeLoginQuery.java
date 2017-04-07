package edu.uark.commands.employees;


import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeLoginQuery implements ResultCommandInterface<Employee>{
	@Override
	public Employee execute()
	{
		if (StringUtils.isBlank(this.getEmployeeId())) {
			return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.INVALID);
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeId(this.getEmployeeId());
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.EMPLOYEE_NOT_FOUND);
		}
	}
	
	private String employeeId;
	private String passwordHash;
	public EmployeeLoginQuery setPasswordHash(String pw)
	{
		this.passwordHash = pw;
		return this;
	}
	public EmployeeLoginQuery setEmployeeId(String emp)
	{
		this.employeeId = emp;
		return this;
	}
	protected String getPasswordHash() //maybe should be protected...
	{
		return passwordHash;
	}
	public String getEmployeeId()
	{
		return employeeId;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeLoginQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeLoginQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
	
}
