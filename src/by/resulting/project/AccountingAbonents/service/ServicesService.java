package by.resulting.project.AccountingAbonents.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import by.resulting.project.AccountingAbonents.dao.ServicesDao;
import by.resulting.project.AccountingAbonents.dao.daoImpl.ServicesDaoImpl;
import by.resulting.project.AccountingAbonents.entity.Services;

public class ServicesService {
	private ServicesDao serviceDao = new ServicesDaoImpl();
	private ServicesDaoImpl serviceDaoImpl = new ServicesDaoImpl();
	
	public List<Services> getAllServices() throws SQLException, NamingException {
		return serviceDao.getAllServices();
	}
}
