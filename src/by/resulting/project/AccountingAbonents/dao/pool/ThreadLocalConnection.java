package by.resulting.project.AccountingAbonents.dao.pool;

import java.sql.Connection;
import java.sql.SQLException;

public class ThreadLocalConnection {
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			try {
				return (Connection) new SimpleBasicDataSource().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	};
	
	public static Connection getConnection() {
		return connectionHolder.get();
	}
	
	public static void removeConnection() {
		connectionHolder.remove();
	}
}
