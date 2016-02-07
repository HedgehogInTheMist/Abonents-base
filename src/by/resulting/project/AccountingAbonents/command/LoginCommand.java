package by.resulting.project.AccountingAbonents.command;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.resulting.project.AccountingAbonents.logic.LoginLogic;
import by.resulting.project.AccountingAbonents.resource.ConfigurationManager;
import by.resulting.project.AccountingAbonents.resource.MessageManager;


public class LoginCommand implements ActionCommand{
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession();
		String enteredLogin = request.getParameter(PARAM_NAME_LOGIN);
		String enteredPass = request.getParameter(PARAM_NAME_PASSWORD);
		try {
			if(LoginLogic.checkLogin(enteredLogin, enteredPass)) {
				session.setAttribute("user", enteredLogin);
				page = ConfigurationManager.getProperty("path.page.main");
			} else {
				session.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
				page = ConfigurationManager.getProperty("path.page.login");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}
	
	
	
}


