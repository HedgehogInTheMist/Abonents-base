package by.resulting.project.AccountingAbonents.logic;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.resulting.project.AccountingAbonents.dao.daoImpl.AbonentDaoImpl;
import by.resulting.project.AccountingAbonents.entity.Abonent;
import by.resulting.project.AccountingAbonents.resource.ConfigurationManager;

public class LoginLogic {
//	private final static String ADMIN_LOGIN = "admin";
//	private final static String ADMIN_PASS = "";
	
	public static boolean checkLogin(String enteredLogin, String enteredPass) throws IOException {
//		String login = request.getParameter("login");
//		String password = request.getParameter("password");
		AbonentDaoImpl abonentDao = new AbonentDaoImpl();
		int id = abonentDao.authenticate(enteredLogin, enteredPass);
		if (id > 0) {
			Abonent abonent = null;
			try {
				abonent = abonentDao.getAbonentByLogin(enteredLogin);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			/*HttpSession session = request.getSession(true);
			session.setAttribute("abonent", abonent);
			if(abonent.getRole().equals("admin")) {
				String adminPage = ConfigurationManager.getProperty("path.page.AdminPanel");
				response.sendRedirect(adminPage);
			} else {
				String abonentPage = ConfigurationManager.getProperty("path.page.AbonentPanel");
				response.sendRedirect(abonentPage);
			}

		} else {
			String errorAuthPage = ConfigurationManager.getProperty("path.page.error");
			response.sendRedirect(errorAuthPage);
		}
		
*/		}
			return true;
	}
}
