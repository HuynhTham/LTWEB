package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.List;

import org.apache.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

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

	public static void writeLog(String ip, String userName, String content, int type) {
		String mess = ip + " " + userName + "  " + content;
		switch (type) {
		case 1: {
			LOGGER.info(mess);
			break;
		}
		case 2: {
			LOGGER.warn(mess);
			break;
		}
		case 3: {
			LOGGER.error(mess);
			break;
		}
		case 4: {
			LOGGER.fatal(mess);
			break;
		}
		}

	}

	public static PreparedStatement queryDB(String query, boolean isWriteLog, String ip, String user, String content,
			List<Object> params, int type) {
		try {
			Connection connection = getConnection();
			PreparedStatement prepare = connection.prepareStatement(query);

			if (!params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					prepare.setObject(i + 1, params.get(i));
				}
			}

			if (isWriteLog)
				writeLog(ip, user, content, type);
			return prepare;

		} catch (Exception e) {
			writeLog(ip, user, content, 4);
	
		
		}
		return null;

	}
	

	public static void main(String[] args) {

	}

}