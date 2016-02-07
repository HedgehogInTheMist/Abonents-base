package by.resulting.project.AccountingAbonents.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.resulting.project.AccountingAbonents.Utils.DBUtils;
import by.resulting.project.AccountingAbonents.dao.AbonentDao;
import by.resulting.project.AccountingAbonents.dao.pool.SimpleBasicDataSource;
import by.resulting.project.AccountingAbonents.entity.Abonent;

public class AbonentDaoImpl implements AbonentDao {
	
	public static final String GET_ABONENTS = "SELECT * FROM users";
	public static final String GET_ONE_ABONENT = "SELECT * FROM users WHERE id = ?";
	public static final String GET_ONE_ABONENT_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
	public static final String EDIT_ABONENT = "UPDATE users SET first_name = ?, second_name = ?, login = ?, password = ? email = ?,  WHERE id = ?";
	public static final String RESET_ACTIVITY = "UPDATE users SET isActive = ? where id = ?";
	public static final String DELETE_ABONENT = "DELETE FROM users WHERE id = ?";
	
	private SimpleBasicDataSource dataSource = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
    ResultSet resultSet = null;
    Abonent abonent = new Abonent();
	
	public AbonentDaoImpl() {
        dataSource = SimpleBasicDataSource.getInstance();
    }
	
	private static AbonentDaoImpl instance;
	public static synchronized AbonentDaoImpl getAbonentDaoImpl() {
		if(instance == null) {
			instance = new AbonentDaoImpl();
		}
		return instance;
	}

	@Override
    public Abonent getAbonentByLogin(String login) throws ClassNotFoundException {
    
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(GET_ONE_ABONENT_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            abonent = initAbonent(resultSet);
            DBUtils.close(preparedStatement, resultSet, connection);
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.err.println("Error SQL Query");
        } finally {
            DBUtils.close(preparedStatement, resultSet, connection);
        }
        return abonent;
    }
	
	@Override 
	public void resetIsActive(long userId, String isActive) throws SQLException, ClassNotFoundException {
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(RESET_ACTIVITY);
			preparedStatement.setString(1, isActive);
			preparedStatement.setLong(2, userId);
	        preparedStatement.executeUpdate();

	        DBUtils.close(preparedStatement, connection);
	    } catch (SQLException e) {
	    	System.err.println("Error SQL Query Why?!!");
	    	e.printStackTrace();
	    } finally {
	        DBUtils.close(preparedStatement, connection);
	    }
	}
	
	@Override
	public void deleteAbonent(long userId) throws SQLException {
		try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_ABONENT);
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
//            DBUtils.close(preparedStatement, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtils.close(preparedStatement,connection);
        }
	}

	@Override
    public Abonent getAbonentById(long n) throws ClassNotFoundException {
    
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(GET_ONE_ABONENT);
            preparedStatement.setLong(1, n);
            resultSet = preparedStatement.executeQuery();
            abonent = initAbonent(resultSet);
            DBUtils.close(preparedStatement, resultSet, connection);
        } catch (SQLException e) {
        	System.err.println("Error SQL Query");
        } finally {
            DBUtils.close(preparedStatement, resultSet, connection);
        }
        return abonent;
    }
	
    private Abonent initAbonent(ResultSet resultSet) throws ClassNotFoundException {
        Abonent abonent = new Abonent();
        try {
            if (resultSet.next()) {
                abonent.setId(resultSet.getLong(1));
                abonent.setFirstName(resultSet.getString(2));
                abonent.setSecondName(resultSet.getString(3));
                abonent.setLogin(resultSet.getString(4));
                abonent.setPassword(resultSet.getString(5));
                abonent.setRole(resultSet.getString(6));
                abonent.setEmail(resultSet.getString(7));
                abonent.setIsActive(resultSet.getString(8));
            }
        } catch (SQLException e) {
        	System.err.println("Error SQL Query");
        }
        return abonent;
    }

    @Override
    public List<Abonent> getAllAbonents() {
        List<Abonent> abonents = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ABONENTS);
            abonents = initAbonents(resultSet);
        } catch (SQLException e) {
        	System.err.println("Error SQL Query");
        } finally {
            DBUtils.close(statement, resultSet, connection);
        }

        return abonents;
    }

    private List<Abonent> initAbonents(ResultSet resultSet) {
        List<Abonent> abonents = new ArrayList<Abonent>();
        try {
            while (resultSet.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getLong(1));
                abonent.setFirstName(resultSet.getString(2));
                abonent.setSecondName(resultSet.getString(3));
                abonent.setLogin(resultSet.getString(4));
                abonent.setPassword(resultSet.getString(5));
                abonent.setRole(resultSet.getString(6));
                abonent.setEmail(resultSet.getString(7));
                abonent.setIsActive(resultSet.getString(8));
                abonents.add(abonent);
            }
        } catch (SQLException e) {
        	System.err.println("Error SQL Query");
        }
        return abonents;
    }


	@Override
	public void editAbonent(Abonent abonent) throws ClassNotFoundException, SQLException {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(EDIT_ABONENT);
            preparedStatement.setLong(1, abonent.getId());
            preparedStatement.setString(2, abonent.getFirstName());
            preparedStatement.setString(3, abonent.getSecondName());
            preparedStatement.setString(4, abonent.getLogin());
            preparedStatement.setString(5, abonent.getPassword());
            preparedStatement.setString(6, abonent.getRole());
            preparedStatement.setString(7, abonent.getEmail());
            preparedStatement.setString(8, abonent.getIsActive());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error SQL Query");
        } finally {
            DBUtils.close(preparedStatement, connection);
        }

	}

	@Override
	public void addAbonent(Abonent abonent) throws ClassNotFoundException, SQLException {
		
	}
	
	public int authenticate(String login, String password) { 

		Connection connection = null;
		String correctPassword = "";
		int id = 0;

		try {
			String queryTemplate = "select * from users where login ='" + login + "';";

			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryTemplate);

			if (resultSet.next() == true) {
				correctPassword = resultSet.getString("password");
				if (correctPassword.equals(password)) {
					id = resultSet.getInt("id");
				}
			}
			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}



