package com.yuvi.testapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuvi.testapp.dao.UserDao;
import com.yuvi.testapp.dao.UserDaoImpl;

import utils.DB;

@Controller
public class AccountController {
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {	
		System.out.print("Controller in login");
		return "login";
	}
	
	@RequestMapping(value = "/notfound", method = RequestMethod.GET)
	public String userNotFound(Model model) {	
		System.out.print("Controller in login");
		return "usernotfound";
	}
	
	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	public String loggedAccounts(HttpServletRequest request) {	
		String username = request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		UserDao ud = new UserDaoImpl();
		ud.initConnection();
		ud.createuser(username, pwd);
		return "login";
	}
	
	
	
	
	@RequestMapping(value = "/account/login", method = RequestMethod.POST)
	public void logIn(HttpServletRequest request, HttpServletResponse response) {	
		String username = request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		UserDao ud = new UserDaoImpl();
		ud.initConnection();
		boolean validuser = ud.isValiduser(username, pwd);
		
		try {
		if(validuser) {
			 response.sendRedirect("http://localhost:8080/testapp");
		}else {
			response.sendRedirect("http://localhost:8080/testapp/notfound");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
