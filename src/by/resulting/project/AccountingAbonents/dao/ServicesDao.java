package by.resulting.project.AccountingAbonents.dao;

import java.util.List;

import by.resulting.project.AccountingAbonents.entity.Abonent;
import by.resulting.project.AccountingAbonents.entity.Services;

public interface ServicesDao {
	
	public void addService(Services services);
	
	public void editService(long serviceId);
	
	public void deleteService(long serviceId);
	
	public List<Services> getAllServices();
	
	public List<Services> getOneAbonentServices(Abonent abonent);
}
