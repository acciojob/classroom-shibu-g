package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	
	public void addstudent(Student st) {
		repo.addstudent(st);
	}
	public void addteacher(Teacher tch) {
		repo.addteacher(tch);
	}
	public void addstudent_teacher(String student,String teacher) {
		repo.addstudent_teacher(student, teacher);
	}
	
	public Student getstudentbyname(String name) {
		return repo.getstudentbyname(name);
	}
	
	public Teacher getteacherbyname(String name) {
		return repo.getteacherbyname(name);
	}
	public List<String>getStudentsByTeacherName(String name){
		return repo.getStudentsByTeacherName(name);
	}
	public List<String>getallstudent(){
		return repo.getallstudent();
	}
	public void deleteteacherbyname(String name) {
		repo.deleteteacherbyname(name);
	}
	public void deleteallteacher() {
		repo.deleteallteacher();
	}
	
}
