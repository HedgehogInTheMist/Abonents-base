package by.resulting.project.AccountingAbonents.command.factory;
import javax.servlet.http.HttpServletRequest;

import by.resulting.project.AccountingAbonents.command.ActionCommand;
import by.resulting.project.AccountingAbonents.command.EmptyCommand;
import by.resulting.project.AccountingAbonents.command.client.CommandEnum;
import by.resulting.project.AccountingAbonents.resource.MessageManager;

public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		String action = request.getParameter("command");
		if(action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch(IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
