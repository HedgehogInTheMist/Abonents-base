package by.resulting.project.AccountingAbonents.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.resulting.project.AccountingAbonents.command.ActionCommand;
import by.resulting.project.AccountingAbonents.resource.ConfigurationManager;

public class EnterCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.enter");
		return page;
	}

}
