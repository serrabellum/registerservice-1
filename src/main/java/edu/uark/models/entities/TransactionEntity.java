package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import org.json.JSONObject;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.TransactionRepository;

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	
	private double totalCost;
	private String employeeId;
	private String date;
	private String transactionType;
	
	protected void fillFromRecord(ResultSet rs) throws SQLException
	{
		
	}
	protected Map<String, Object> fillRecord(Map<String,Object> record)
	{
		record.put(TransactionFieldNames.ID, this.id);
		record.put(TransactionFieldNames.TOTAL_COST, this.totalCost);
		record.put(TransactionFieldNames.DATE, date);
		record.put(TransactionFieldNames.TYPE, transactionType);
		return record;
	}
	
	public double getTotalCost()
	{
		return this.totalCost;
	}
	public String getEmployeeId()
	{
		return this.employeeId;
	}
	public String getTransactionType()
	{
		return this.transactionType;
	}
	public String getDate()
	{
		return this.date;
	}
	public TransactionEntity setTotalCost(double in)
	{
		if(totalCost != in)
		{
			this.totalCost = in;
			this.propertyChanged(TransactionFieldNames.TOTAL_COST);
		}
		return this;
	}
	public TransactionEntity setDate(String in)
	{
		if(!in.equals(date))
		{
			this.date = in;
			this.propertyChanged(TransactionFieldNames.DATE);
		}
		return this;
	}
	public TransactionEntity setEmployeeId(String in)
	{
		if(!(this.employeeId.equals(in)))
		{
			this.employeeId = in;
			this.propertyChanged(TransactionFieldNames.EMPLOYEE_ID);
		}
		return this;
	}
	public TransactionEntity setTransactionType(String in)
	{
		if(!(this.transactionType.equals(in)))
		{
			this.transactionType = in;
			this.propertyChanged(TransactionFieldNames.TYPE);
		}
		return this;
	}
	
	public Transaction synchronize(Transaction apiTransaction)
	{
		this.setTotalCost(apiTransaction.getTotalCost());
		this.setDate(apiTransaction.getDate());
		this.setEmployeeId(apiTransaction.getEmployeeId());
		this.setTransactionType(apiTransaction.get)
	}
	
	
	
	
	public TransactionEntity()
	{
		super(new TransactionRepository());
	}
	public TransactionEntity(Transaction transaction)
	{
		super(transaction.getId(), new TransactionRepository());
	}
}
