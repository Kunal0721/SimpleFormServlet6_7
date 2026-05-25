package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

import java.io.IOException;

import entity.Student;

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
		if(i != 0) {
			System.out.println("success..");
		}
		else {
			System.out.println("Something went wrong..");
		}
	}

}
