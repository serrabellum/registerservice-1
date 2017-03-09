package edu.uark.models.repositories;

import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeRepository extends BaseRepository<EmployeeEntity> implements EmployeeRepositoryInterface
{
	public EmployeeRepository () {
		super(DatabaseTable.EMPLOYEE); //Need to add Employee implementation
		//More to be added
	}

	@Override
	protected EmployeeEntity createOne() {
		//More to be Added
		return null;
	}

	@Override
	public EmployeeEntity byEmployeeId(String employeeId) {
		return this.firstOrDefaultWhere(
				new WhereContainer(
					(new WhereClause()).
						postgreFunction(PostgreFunctionType.LOWER).
						table(this.primaryTable).
						fieldName(EmployeeFieldNames.EMPLOYEEID).
						comparison(SQLComparisonType.EQUALS)
				),
				(ps) -> {
					try {
						ps.setObject(1, employeeId);
					} catch (SQLException e) {}

					return ps;
				}
			);
	}
	

}
