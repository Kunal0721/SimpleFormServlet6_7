package controller;

import java.io.IOException;
import java.util.List;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao = new StudentDAO();

	public ReadServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> student = dao.getAll();
		request.setAttribute("Student", student);
		request.getRequestDispatcher("read.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
