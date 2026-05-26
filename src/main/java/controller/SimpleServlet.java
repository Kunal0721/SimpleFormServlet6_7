package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

@WebServlet("/abc")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SimpleServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("nm");
		int age = Integer.parseInt(request.getParameter("age"));
		String course = request.getParameter("course");

		StudentDAO dao = new StudentDAO();
		Student st = new Student(name, age, course);
		int i = dao.insert(st);
		PrintWriter out = response.getWriter();
		if (i != 0) {

			out.println("<h1 align='center'> Success </h1>");
			out.println("<h1> Welcome : " + name + "</h1>");

			List<Student> ls = dao.getAll();
			out.println("<center>");
			for (Student s : ls) {

				out.println(s.getId() + "   " + s.getName() + "   " + s.getAge() + "   " + s.getCourse() + "<br>");

			}
			out.println("</center>");
		} else {
			out.println("<h1> Something went wrong </h1>");
		}
	}

}
