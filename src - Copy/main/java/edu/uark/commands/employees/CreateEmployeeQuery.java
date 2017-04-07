package edu.uark.commands.employees;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class CreateEmployeeQuery  implements ResultCommandInterface<Employee>{

	@Override
	public Employee execute() {
		if(StringUtils.isBlank(this.newEmployee.getEmployeeId()))
		{
			return (new Employee()).setApiRequestStatus(EmployeeApiRequestStatus.INVALID);
		}
		EmployeeEntity employeeEntity = this.employeeRepository.get(this.newEmployee.getId());
		if(employeeEntity != null)
		{
			return (new Employee()).setApiRequestStatus(EmployeeApiRequestStatus.EMPLOYEE_ALREADY_EXISTS);
		}
		employeeEntity = new EmployeeEntity(this.newEmployee);
		employeeEntity.save();
		if ((new UUID(0, 0)).equals(this.newEmployee.getId())) {
			this.newEmployee.setEmployeeUUID(employeeEntity.getId());
		}
		return this.newEmployee;
	}
	private Employee newEmployee;
	public Employee getEmployee()
	{
		return this.newEmployee;
	}
	public CreateEmployeeQuery setNewEmployee(Employee newEmployee)
	{
		this.newEmployee = newEmployee;
		return this;
	}
	private EmployeeRepositoryInterface employeeRepository;

	public EmployeeRepositoryInterface getEmployeeRepository()
	{
		return this.employeeRepository;
	}
	public CreateEmployeeQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository)
	{
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public CreateEmployeeQuery()
	{
		this.employeeRepository = new EmployeeRepository();
	}
	
}
