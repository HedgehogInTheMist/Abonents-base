package by.resulting.project.AccountingAbonents.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.istack.internal.logging.Logger;

import by.resulting.project.AccountingAbonents.dao.*;
import by.resulting.project.AccountingAbonents.dao.daoImpl.AbonentDaoImpl;
import by.resulting.project.AccountingAbonents.entity.Abonent;

/**
 * Filter implements authentification
 */

public class AuthFilter implements Filter {

	final Logger log = Logger.getLogger(AuthFilter.class);
	
	public void init(FilterConfig fConfig) throws ServletException {
	}    

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		AbonentDaoImpl abonentDao = new AbonentDaoImpl();
		int id = abonentDao.authenticate(login, password);
		if (id > 0) {
			Abonent abonent = null;
			try {
				abonent = abonentDao.getAbonentByLogin(login);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			HttpSession session = ((HttpServletRequest) request).getSession(true);
			session.setAttribute("abonent", abonent);
			if(abonent.getRole().equals("admin")) {
				((HttpServletResponse) response).sendRedirect("./pages/AdminPanel.jsp");
			} else {
				if(abonent.getRole().equals("customer")) {
				((HttpServletResponse) response).sendRedirect("./pages/AbonentPanel.jsp");
			    } else {
				((HttpServletResponse) response).sendRedirect("./pages/errorAuth.jsp");
			      }
			  }
		}
	}
	
	public void destroy() {
	}


}
