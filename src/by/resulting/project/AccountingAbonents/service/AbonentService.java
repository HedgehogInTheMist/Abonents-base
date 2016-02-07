package by.resulting.project.AccountingAbonents.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import by.resulting.project.AccountingAbonents.dao.AbonentDao;
import by.resulting.project.AccountingAbonents.dao.daoImpl.AbonentDaoImpl;
import by.resulting.project.AccountingAbonents.entity.Abonent;
import by.resulting.project.AccountingAbonents.exceptions.AbonentNotFoundException;
import by.resulting.project.AccountingAbonents.exceptions.PasswordMismatchException;

public class AbonentService {
	
	private AbonentDao abonentDao = new AbonentDaoImpl();
	private AbonentDaoImpl abonentDaoImpl = new AbonentDaoImpl();
	
	public Abonent getAbonentById(long n) throws SQLException, NamingException, ClassNotFoundException  {
		return abonentDao.getAbonentById(n);
	}
	
	public Abonent getAbonentByLogin(String login) throws SQLException, NamingException, ClassNotFoundException  {
		return abonentDao.getAbonentByLogin(login);
	}
	
	public List<Abonent> getAllAbonents() throws SQLException, ClassNotFoundException, NamingException {
		return abonentDao.getAllAbonents();
	}
	
	public void editAbonent(long userId, String firstName, String secondName, String password, String login) throws ClassNotFoundException, SQLException, NamingException {
        Abonent abonent = abonentDaoImpl.getAbonentById(userId);
        abonent.setFirstName(firstName);
        abonent.setSecondName(secondName);
        abonent.setPassword(password);
        abonent.setLogin(login);
        
        abonentDao.editAbonent(abonent);
    }
	
	public void resetIsActive(long userId, String isActive) throws SQLException, ClassNotFoundException, NamingException {
		abonentDao.resetIsActive(userId, isActive);
	}
	
	public void deleteAbonent(long userId) throws SQLException, ClassNotFoundException, NamingException {
		abonentDao.deleteAbonent(userId);;
	}
	
	public boolean checkAbonent(Abonent abonent) throws AbonentNotFoundException, PasswordMismatchException {
		
		Abonent abonentById = null;
		boolean abonentMatched = false;
		
		try {
			
			try {
				abonentById = abonentDao.getAbonentById(abonent.getId());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			if (abonentById != null) {
				if (abonentById.getPassword().equals(abonent.getPassword())) {
					abonentMatched = true;
				} else {
					throw new PasswordMismatchException("Passwords mismatch!"); 
				}
			} else {
				throw new AbonentNotFoundException("Such abonent doesn't exist.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abonentMatched;
	} 

	
}
