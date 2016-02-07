package by.resulting.project.AccountingAbonents.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;

import by.resulting.project.AccountingAbonents.entity.Entity;

public abstract class AbstractDao<K, T extends Entity> {
	
	private static final String DB_NAME = "call_office";
	
//	private static final DataSource DATA_SOURCE = getDataSource();
	
	/*private static DataSource getDataSource() {
		
		Context initCtxt = null;
		
		DataSource dataSource = null;
		
		try {
			
			initCtxt = new InitialContext();
			
			dataSource = (DataSource) initCtxt.lookup("java:/comp/env/jdbc/" + DB_NAME); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return DATA_SOURCE;
	}
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			
			conn = DATA_SOURCE.getConnection();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			// ...
		}
		
		return conn;
	}*/
	
	public static void close(Statement preparedStatement, Connection connection) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement preparedStatement, ResultSet resultSet, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }	
}
