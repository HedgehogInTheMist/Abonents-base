package by.resulting.project.AccountingAbonents.command;

import javax.servlet.http.HttpServletRequest;
import by.resulting.project.AccountingAbonents.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		request.getSession().invalidate();
		return page;
	}

}
