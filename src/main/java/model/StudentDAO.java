package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Student;

public class StudentDAO {

	// insert :
	public int insert(Student st) {
		int i = 0;

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("insert into student(name, age, course) values (?, ?, ?)");
			pst.setString(1, st.getName());
			pst.setInt(2, st.getAge());
			pst.setString(3, st.getCourse());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	// read all : 
	public List<Student> getAll(){
		List<Student> ls = new LinkedList<>();
		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String course = rs.getString("course");
				
				ls.add(new Student(id, name, age, course));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
}
