package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import Log.Log;

public class DataSource {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/animeweb";
	private static final String USER = "root";
	private static final String PASS = "Linh@27092002";
	private static HikariConfig config = new HikariConfig();
	private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static HikariDataSource ds;
	static final Logger LOGGER = Logger.getLogger(DataSource.class);

	static {

		config.setJdbcUrl(DB_URL);
		config.setUsername(USER);
		config.setPassword(PASS);
		config.setDriverClassName(CLASS_NAME);
		config.setMinimumIdle(5);
		config.setMaximumPoolSize(30);
		config.setConnectionTimeout(50000);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.setIdleTimeout(Long.MAX_VALUE);
		ds = new HikariDataSource(config);

	}
	
	private DataSource() {
	}

	public static void closeConnection() {
		ds.close();
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static boolean insertLog(Log log) throws SQLException {
	
		String query ="INSERT INTO `animeweb`.`log` (`level`, `user`, `ip`, `src`, `content`,`status`) values(?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(log.getLevel());
		params.add(log.getUserId());
		params.add(log.getIp());
		params.add(log.getSrc());
		params.add(log.getContent());
		params.add(log.getStatus());
		
		try(PreparedStatement prepare = queryDB(query, params)){
			int row =prepare.executeUpdate();
			return row==1;
		}
	}

	public static PreparedStatement queryDB(String query,
			List<Object> params) {
		try {
			Connection connection = getConnection();
			PreparedStatement prepare = connection.prepareStatement(query);

			if (!params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					prepare.setObject(i + 1, params.get(i));
				}
			}

			
			return prepare;

		} catch (Exception e) {
		
	
		
		}
		return null;

	}
	

	public static void main(String[] args) {

	}

}