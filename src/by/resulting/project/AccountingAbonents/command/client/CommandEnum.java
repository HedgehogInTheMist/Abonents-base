package by.resulting.project.AccountingAbonents.command.client;
import by.resulting.project.AccountingAbonents.command.*;
/*import by.resulting.project.AccountingAbonents.command.EnterCommand;
import by.resulting.project.AccountingAbonents.command.LoginCommand;
import by.resulting.project.AccountingAbonents.command.LogoutCommand;*/

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	}, 
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	ENTER {
		{
			this.command = new EnterCommand();
		}
	};
	
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
