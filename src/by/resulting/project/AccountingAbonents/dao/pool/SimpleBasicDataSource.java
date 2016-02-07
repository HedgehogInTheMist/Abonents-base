package by.resulting.project.AccountingAbonents.dao.pool;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

//import static by.courses.constants.Constants.*;

public class SimpleBasicDataSource {
	
	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String dbURL = "jdbc:mysql://localhost:3306/call_office";
    public static final String USER = "root";
    public static final String PASSWORD = "1234";
	
    private static SimpleBasicDataSource instance;
    private BasicDataSource bds;

    SimpleBasicDataSource() {

            bds = new BasicDataSource();
            bds.setUrl(dbURL);
            bds.setDriverClassName(DRIVER_CLASS_NAME);
            bds.setUsername(USER);
            bds.setPassword(PASSWORD);
    }

    public static synchronized SimpleBasicDataSource getInstance() {
        if (instance == null) {
            instance = new SimpleBasicDataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return bds.getConnection();
    }

}
