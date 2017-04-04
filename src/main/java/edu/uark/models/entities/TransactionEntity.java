package edu.uark.models.entities;

import java.sql.ResultSet;
import java.util.Map;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Transaction;

public class TransactionEntity extends BaseEntity<Transaction> {
	protected void fillFromRecord(ResultSet rs) throws SQLException
	{
		
	}
	protected Map<String, Object> fillRecord(Map<String,Object> record)
	{
		return null;
	}
}
