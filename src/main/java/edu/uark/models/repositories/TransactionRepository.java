package edu.uark.models.repositories;

import java.util.Collection;
import java.util.LinkedList;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;


public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface{
	public TransactionEntity byTransactionId(String id)
	{
		return null;
	}
	public TransactionRepository()
	{
		super(DatabaseTable.TRANSACTION);
	}
	@Override
	protected TransactionEntity createOne() {
		// TODO Auto-generated method stub
		return null;
	}
	protected void insert(TransactionEntity entity)
	{
	}
	protected void insert(Collection<TransactionEntity> entityCollection)
	{
	}
	
}
