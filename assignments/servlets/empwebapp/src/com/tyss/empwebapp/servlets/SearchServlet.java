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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession(false);
		if(session==null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
			dispatcher.forward(req, resp);
		}
			int id = Integer.parseInt(req.getParameter("search"));
			EmployeeDAO dao = EmployeeDAOManager.getEmployeeDAO();
			EmployeeInfo info = dao.searchEmployee(id);
			
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<a href='./home'>Home</a>");
			out.println("<a  href='./logout'>Logout</a>");
			
			if(info!=null) {
			out.println("<table align='center'>");
			out.println("<tr>");
            out.println("<th>");
			out.println("Id</th><th>Name</th><th>Email");
			out.println("</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println(info.getId());
			out.println("</td>");
			out.println("<td>");
			out.println(info.getName());
			out.println("</td>");
			out.println("<td>");
			out.println(info.getEmail());
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			}else {
				out.println("<h2 style='color:red'>No Data Found</h2");
			}
			out.println("</body>");
			out.println("</html>");
		
	}//end of doGet()
}//end of SearchServlet
