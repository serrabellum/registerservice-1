package edu.uark.models.repositories;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
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
	
	
}
