package it.servicies.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.model.TestTable;
import it.servicies.ITransactionalService;

@Service
public class TransactionalService implements ITransactionalService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.NEVER)
	public List<TestTable> getTestByEta(int eta) {
		String query = "select nome, cognome, eta from test where eta BETWEEN 42 AND " + eta;
		
		List<TestTable> result =  jdbcTemplate.query(query, new ResultSetExtractor<List<TestTable>>() {

			@Override
			public List<TestTable> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<TestTable> tests = new ArrayList<>();
				while(rs.next())
					tests.add(new TestTable(rs.getString(1), rs.getString(1), rs.getInt(3)));
				return tests;
			}
		});
		
		return result;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void updateTest(TestTable test) {
		jdbcTemplate.execute("insert into test values ('"+test.getNome()+"', '"+test.getCognome()+"', "+test.getEta()+")");
		System.out.println("no commit yet");
	}

}
