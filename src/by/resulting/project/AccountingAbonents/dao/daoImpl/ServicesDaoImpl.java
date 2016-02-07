package by.resulting.project.AccountingAbonents.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.logging.Logger;

import by.resulting.project.AccountingAbonents.Utils.DBUtils;
import by.resulting.project.AccountingAbonents.dao.ServicesDao;
import by.resulting.project.AccountingAbonents.entity.Abonent;
import by.resulting.project.AccountingAbonents.entity.Services;
import by.resulting.project.AccountingAbonents.dao.pool.SimpleBasicDataSource;

public class ServicesDaoImpl implements ServicesDao {
	
	Logger log = Logger.getLogger(ServicesDaoImpl.class);
	private SimpleBasicDataSource dataSource = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Services service = new Services();
	
	public ServicesDaoImpl() {
		dataSource = SimpleBasicDataSource.getInstance();
	}
	
	private static ServicesDaoImpl instance;
	public static synchronized ServicesDaoImpl getServicesDaoImpl() {
		if(instance == null) {
			instance = new ServicesDaoImpl();
		}
		return instance;
	}
	/*
	 * Getting all accessible (actual) services in DB
	 */
	@Override
	public List<Services> getAllServices() {
		final String GET_SERVICES = "SELECT * FROM services";
		List<Services> services = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_SERVICES);
			services = initServices(resultSet);
		} catch(SQLException e) {
			System.err.println("Error SQL Query");
		} finally {
			DBUtils.close(statement, connection);
		}
		return services;
	}
	
	/*
	 * Supplement additional service for abonent's pleasure. Admin's prerogative.
	 */
	@Override
	public void addService(Services services) {
		final String ADD_SERVICE = "INSERT INTO services(service_name, service_cost, description) VALUES (?, ?, ?);";
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(ADD_SERVICE);
			preparedStatement.setString(1, service.getServiceName());
			preparedStatement.setInt(2, service.getServiceCost());
			preparedStatement.setString(3, service.getDescription());
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
	}

	@Override
	public void editService(long serviceId) {
		final String DELETE_SERVICE = "DELETE FROM services WHERE id = ?;";
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SERVICE);
			preparedStatement.setLong(1, serviceId);
			preparedStatement.executeUpdate();
//			DBUtils.close(preparedStatement, connection);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
		} DBUtils.close(preparedStatement, connection);
	}

	@Override
	public void deleteService(long serviceId) {
	}

	@Override
	public List<Services> getOneAbonentServices(Abonent abonent) {
		return null;
	}
	/*
	 * Utilitarian method for filling List<Service> with all Services from DB 
	 */
	private List<Services> initServices(ResultSet resultSet) {
		List<Services> services = new ArrayList<Services>();
		try {
			while(resultSet.next()) {
				Services service = new Services();
				service.setId(resultSet.getLong(1));
				service.setServiceName(resultSet.getString(2));
				service.setServiceCost(resultSet.getInt(3));
				service.setDescription(resultSet.getString(4));
				services.add(service);
			}
		} catch(SQLException e) {
			System.out.println("Error SQL Query");
		}
		return services;
	}

}
