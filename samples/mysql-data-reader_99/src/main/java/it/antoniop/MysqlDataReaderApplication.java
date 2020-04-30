package it.antoniop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class MysqlDataReaderApplication  implements CommandLineRunner  {
	
	private static final Logger LOG = LoggerFactory.getLogger(MysqlDataReaderApplication.class);

	private static final String QRY = " SELECT 'unoA1' as A, 'dueB1' as B, 'treC1' as C, 'quattroD1' as D "
			                        + "   UNION " 
			                        + " SELECT 'unoA2' as A, 'dueB2' as B, 'treC2' as C, 'quattroD2'  as D ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private DummiestQryRowMapper dummiestQryRowMapper;
	
	
	@Override
	public void run(String... args) throws Exception {
		LOG.info("*** Let's query tables");

		jdbcTemplate.query(QRY, dummiestQryRowMapper);
	}


	@Component
	private class DummiestQryRowMapper implements RowMapper<Object> {
		
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (rowNum==0) {
				LOG.info("*** ------------------------------------------------------------------------------------");					
			}
			String msg = "*** " + rs.getString("A") + " | " + rs.getString("B") + " | "+ rs.getString("C") + " | " + rs.getString("D");
			LOG.info(msg);
			return null;
		}
		
		
		@PostConstruct
		public void initDone() {
			LOG.info("***  DummiestQryRowMapper instance has been created .... ");
			
			jdbcTemplate.execute(new StatementCallback<Object>() {
				// @Transactional()
				public Object doInStatement(Statement stmt) throws SQLException, DataAccessException {
					ResultSet rs = stmt.executeQuery(" SELECT version() ");
					rs.next();
					LOG.info("*** MySQL version is " + rs.getString(1));
					return null;
				}
			});
			LOG.info("*** ------------------------------------------------------------------------------------\n");
		}
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(MysqlDataReaderApplication.class, args);
	}

	
	
}
