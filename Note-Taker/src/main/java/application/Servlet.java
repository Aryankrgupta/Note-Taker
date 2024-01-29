package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Servlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		String cPassword = req.getParameter("cpassword");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if(password.equals(cPassword)) {
			Service s = new Service();
			Register r = new Register(password, user);
			System.out.println(r);
			s.register(r);
			Register reg = s.getUser(user);
			System.out.println(reg);
			List<Notes> note =  s.getNotes(reg.getUserId());
			req.setAttribute("register", reg);
			req.setAttribute("note", note);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		} else {
			out.println("<h1 style='color:red' align=\"center\">Password Mismatch</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		}
	}
}
