package application;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crud")
public class Delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int user = Integer.parseInt(req.getParameter("user"));
		String action = req.getParameter("action");
		Service s = new Service();
		if (action.equals("delete")) {
			s.delete(id);
			Register reg = s.getUser(user);
			System.out.println(reg);
			List<Notes> note =  s.getNotes(reg.getUserId());
			req.setAttribute("register", reg);
			req.setAttribute("note", note);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		} else {
			Notes n = s.getNoteById(id);
			req.setAttribute("note", n);
			RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
			rd.forward(req, resp);
		}
	}
}
