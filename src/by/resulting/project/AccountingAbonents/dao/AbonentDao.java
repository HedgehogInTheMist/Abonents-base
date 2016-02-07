package by.resulting.project.AccountingAbonents.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import by.resulting.project.AccountingAbonents.entity.Abonent;

public interface AbonentDao {
	
	public int authenticate(String login, String password);
	
	public Abonent getAbonentById(long userId) throws SQLException, NamingException, ClassNotFoundException;
	
	public Abonent getAbonentByLogin(String login) throws SQLException, NamingException, ClassNotFoundException;
	
	public List<Abonent> getAllAbonents() throws SQLException, NamingException;
	
	public void addAbonent(Abonent abonent) throws ClassNotFoundException, SQLException;
	
	public void editAbonent(Abonent abonent) throws ClassNotFoundException, SQLException;
	
	public void resetIsActive(long userId, String isActive) throws SQLException, ClassNotFoundException;
	
	void deleteAbonent(long userId) throws SQLException;
}
