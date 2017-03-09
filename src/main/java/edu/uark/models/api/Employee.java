package edu.uark.models.api;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.api.enums.ProductApiRequestStatus;


public class Employee {
	private UUID id;
	private String FirstName;
	private String LastName;
	private String EmployeeId;
	private String password;
	
	public UUID getId() {
		return this.id;
	}
	public void setEmployeeUUID(UUID in)
	{
		id = in;
	}
	public String getEmployeeId()
	{
		return this.EmployeeId;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getFirst()
	{
		return this.FirstName;
	}
	public String getLast()
	{
		return this.LastName;
	}
	
	
	private EmployeeApiRequestStatus apiRequestStatus;
	public EmployeeApiRequestStatus getApiRequestStatus()
	{
		return this.apiRequestStatus;
	}
	
	public Employee setApiRequestStatus(EmployeeApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Employee setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	
	public Employee(EmployeeEntity employeeEntity){
		
	}
	public Employee(String employeeId, String password, String first, String last)
	{
		this.EmployeeId = employeeId;
		this.password = password;
		this.FirstName = first;
		this.LastName = last;
	}
	public Employee(){
		
	}
	
	
}
