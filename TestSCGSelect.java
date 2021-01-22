package com.example.web;

import com.example.model.TestSCGExpert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
/*import javax.servlet.http.Cookie;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession; */
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.example.dao.UserDao;
import com.example.model.User;
import java.sql.PreparedStatement;

import java.lang.System;

public class TestSCGSelect extends HttpServlet {
	
	private UserDao userDao;
	public void init() {
		userDao = new UserDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("test init parameters<br>");

		 @SuppressWarnings("rawtypes")
		java.util.Enumeration e = getServletConfig().getInitParameterNames();
		 while(e.hasMoreElements()) {
		 out.println("<br>param name = " + e.nextElement() + "<br>");
		 }
		 out.println("main 1 email is " + getServletConfig().getInitParameter("main1Email"));
		 out.println("<br>");
		 out.println("admin 1 email is " + getServletConfig().getInitParameter("admin1Email"));
		 out.println("main 2 email is " + getServletConfig().getInitParameter("main2Email"));
		 out.println("<br>");
		 out.println("admin 2 email is " + getServletConfig().getInitParameter("admin2Email"));
		
		/*HttpSession session = request.getSession();
		
		if (session.isNew()) {
			 out.println("This is a new session.");
		} else {
			 out.println("Welcome back!");
		}
		 
		session.setMaxInactiveInterval(20*60); */
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root1234");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.getAllUser();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		
		request.setAttribute("listUser", listUser);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("email", email);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("email", email);
		User newUser = new User(name, age, email);
		userDao.saveUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("email", email);
		User user = new User(id, name, age, email);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}

	
	private static final long serialVersionUID = 1L;
	
	public TestSCGSelect(){
		
	}
	
	public class TestSCGSessionCounter implements HttpSessionListener {

		 private int activeSessions;
		 public int getActiveSessions() {
		 return activeSessions;
		 }


		 public void sessionCreated(HttpSessionEvent event) {
		 activeSessions++;
		 }
		 public void sessionDestroyed(HttpSessionEvent event) {
		 activeSessions--;
		 }
	}
	
	public class TestSCGAttributeListener implements HttpSessionAttributeListener {

		 public void attributeAdded(HttpSessionBindingEvent event) {
		 String name = event.getName();
		 Object value = event.getValue();
		 System.out.println("Attribute added: " + name + ": " + value);
		 }
		 public void attributeRemoved(HttpSessionBindingEvent event) {
		 String name = event.getName();
		 Object value = event.getValue();
		 System.out.println("Attribute removed: " + name + ": " + value);
		 }
		 public void attributeReplaced(HttpSessionBindingEvent event) {
		 String name = event.getName();
		 Object value = event.getValue();
		 System.out.println("Attribute replaced: " + name + ": " + value);
		 }
	}
	
	/*public static class Counter {
		 private static int count;
		 public static synchronized int getCount() {
			 count++;
		 return count;
		 }
	} */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			
			int quest1 = Integer.parseInt(request.getParameter("quest1"));
			int quest2 = Integer.parseInt(request.getParameter("quest2"));
			int quest3 = Integer.parseInt(request.getParameter("quest3"));
			int quest4 = Integer.parseInt(request.getParameter("quest4"));
			int quest5 = Integer.parseInt(request.getParameter("quest5"));
			int quest6 = Integer.parseInt(request.getParameter("quest6"));
			int quest7 = Integer.parseInt(request.getParameter("quest7"));
			int quest8 = Integer.parseInt(request.getParameter("quest8"));
			int quest9 = Integer.parseInt(request.getParameter("quest9"));
			int quest10 = Integer.parseInt(request.getParameter("quest10"));
			
			int quest11 = Integer.parseInt(request.getParameter("quest11"));
			int quest12 = Integer.parseInt(request.getParameter("quest12"));
			int quest13 = Integer.parseInt(request.getParameter("quest13"));
			int quest14 = Integer.parseInt(request.getParameter("quest14"));
			int quest15 = Integer.parseInt(request.getParameter("quest15"));
			int quest16 = Integer.parseInt(request.getParameter("quest16"));
			int quest17 = Integer.parseInt(request.getParameter("quest17"));
			int quest18 = Integer.parseInt(request.getParameter("quest18"));
			int quest19 = Integer.parseInt(request.getParameter("quest19"));
			int quest20 = Integer.parseInt(request.getParameter("quest20"));
			
			int quest21 = Integer.parseInt(request.getParameter("quest21"));
			int quest22 = Integer.parseInt(request.getParameter("quest22"));
			int quest23 = Integer.parseInt(request.getParameter("quest23"));
			int quest24 = Integer.parseInt(request.getParameter("quest24"));
			int quest25 = Integer.parseInt(request.getParameter("quest25"));
			int quest26 = Integer.parseInt(request.getParameter("quest26"));
			int quest27 = Integer.parseInt(request.getParameter("quest27"));
			int quest28 = Integer.parseInt(request.getParameter("quest28"));
			int quest29 = Integer.parseInt(request.getParameter("quest29"));
			int quest30 = Integer.parseInt(request.getParameter("quest30"));
			
			TestSCGExpert be = new TestSCGExpert();
			
			float resProfil1 = be.getResProfil1(quest1, quest17, quest18, quest19, quest29);
			float resProfil2 = be.getResProfil2(quest5, quest9, quest10, quest11, quest12, quest13, quest14, quest15, quest28);
			float resProfil3 = be.getResProfil3(quest1, quest4, quest16, quest18, quest29);
			float resProfil4 = be.getResProfil4(quest3, quest6, quest7, quest17, quest27, quest29);
			
			float resField1 = be.getResField1(quest2, quest4, quest10, quest14, quest15, quest16, quest17, quest24, quest27, quest28);
			float resField2 = be.getResField2(quest5, quest7, quest8, quest10, quest21, quest22, quest23, quest27);
			float resField3 = be.getResField3(quest5, quest7, quest21, quest25, quest26, quest27);
			float resField4 = be.getResField4(quest17, quest20, quest27, quest29, quest30);
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("age", age);
			request.setAttribute("email", email);
			
			request.setAttribute("resProfil1", resProfil1);
			request.setAttribute("resProfil2", resProfil2);
			request.setAttribute("resProfil3", resProfil3);
			request.setAttribute("resProfil4", resProfil4);
			
			request.setAttribute("resField1", resField1);
			request.setAttribute("resField2", resField2);
			request.setAttribute("resField3", resField3);
			request.setAttribute("resField4", resField4);
			
		/*	Cookie cookie = new Cookie("name", name);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);  */
			
			
			Connection conn = getConnection();
			
			String query = " insert into users (name, age, email)"
			        + " values (?, ?, ?)";

			PreparedStatement preparedStmt;
			try {
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString (1, name);
				preparedStmt.setInt (2, age);
				preparedStmt.setString (3, email);
				preparedStmt.execute();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
}