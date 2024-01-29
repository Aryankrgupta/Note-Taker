package application;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		Service s = new Service();
		boolean l = s.login(user, password);
		if(l) {
			Register reg = s.getUser(user);
			System.out.println(reg);
			List<Notes> note =  s.getNotes(reg.getUserId());
			req.setAttribute("register", reg);
			req.setAttribute("note", note);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		} else {
			resp.getWriter().println("<h1 style='color:red' align=\"center\">You are not Register</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		}
	}
}
