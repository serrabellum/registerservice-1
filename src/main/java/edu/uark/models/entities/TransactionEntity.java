package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.json.JSONObject;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Transaction;
import edu.uark.models.repositories.TransactionRepository;

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	protected void fillFromRecord(ResultSet rs) throws SQLException
	{
		
	}
	protected Map<String, Object> fillRecord(Map<String,Object> record)
	{
		return null;
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
