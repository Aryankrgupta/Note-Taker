package application;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String userId = req.getParameter("userId");
		String title = req.getParameter("title");
		String note = req.getParameter("note");
		System.out.println(id);
		Notes n = new Notes(title, note, id);
		System.out.println(n);
		Service s = new Service();
		int no = s.update(n);
		Register reg = s.getUser(Integer.parseInt(userId));
		System.out.println(reg);
		List<Notes> notes =  s.getNotes(reg.getUserId());
		req.setAttribute("register", reg);
		req.setAttribute("note", notes);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
