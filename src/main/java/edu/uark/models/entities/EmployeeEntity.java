package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.EmployeeRepository;

public class EmployeeEntity extends BaseEntity<EmployeeEntity>{
	
	
	private String employeeId;
	private String password;
	
	
	
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException
	{
		this.employeeId = rs.getString(EmployeeFieldNames.EMPLOYEEID);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
	}
	@Override
	protected Map<String, Object> fillRecord(Map<String,Object> record)
	{
		record.put(EmployeeFieldNames.EMPLOYEEID, this.employeeId);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		return record;
	}
	public EmployeeEntity()
	{
		super(new EmployeeRepository());
	}
	public EmployeeEntity(Employee employee)
	{
		super(employee.getId(), new EmployeeRepository());
		this.employeeId = employee.getEmployeeId();
		this.password = employee.getPassword();
	}
	
}
