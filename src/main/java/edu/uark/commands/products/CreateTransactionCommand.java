package edu.uark.commands.products;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.Transaction;
import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class CreateTransactionCommand {

	public CreateTransactionCommand setApiTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction execute() {
		if(apiTransaction.isBlank())
		{
			return (new Transaction().setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT));
		}
		TransactionEntity transactionEntity = this.transactionRepository.get(this.apiTransaction.getId());
		if(transactionEntity != null)
		{
			this.apiTransaction = transactionEntity.synchronize(this.apiTransaction);
		}
	}
	private Transaction apiTransaction;
	public Transaction getApiTransaction()
	{
		return this.apiTransaction;
	}
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository()
	{
		return this.transactionRepository;
	}
	public CreateTransactionCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository)
	{
		this.transactionRepository = transactionRepository;
		return this;
	}
	public CreateTransactionCommand()
	{
		this.transactionRepository = new TransactionRepository();
	}
	
}
