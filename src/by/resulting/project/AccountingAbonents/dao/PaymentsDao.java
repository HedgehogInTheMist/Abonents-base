package by.resulting.project.AccountingAbonents.dao;

import java.util.List;

import by.resulting.project.AccountingAbonents.entity.Abonent;
import by.resulting.project.AccountingAbonents.entity.Payments;

public interface PaymentsDao {
	
	public List<Payments> getPayments();
	
	public List<Payments> getOneAbonentPayments(Abonent abonent);
	
	
}
