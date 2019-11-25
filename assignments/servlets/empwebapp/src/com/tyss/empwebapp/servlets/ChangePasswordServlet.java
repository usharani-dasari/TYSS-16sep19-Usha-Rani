package com.tyss.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.empwebapp.dao.EmployeeDAO;
import com.tyss.empwebapp.dto.EmployeeInfo;
import com.tyss.empwebapp.util.EmployeeDAOManager;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session!=null) {
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmpassword");
		
		
		PrintWriter out = resp.getWriter();
		if(password.equals(confirmpassword)) {
			Object obj = session.getAttribute("info");
			EmployeeInfo info = (EmployeeInfo)obj;
			int id = info.getId();
			
			
			EmployeeDAO dao = EmployeeDAOManager.getEmployeeDAO();
			dao.changePassword(id, password);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);
			
			
		}else {
			out.println("<html>");
			out.println("<h4 style='color:red'>Password not Matching</h2>");
			out.println("</html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/changepassword.html");
			dispatcher.include(req, resp);
			
			
		}
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
			dispatcher.forward(req, resp);
		}
	}

}
