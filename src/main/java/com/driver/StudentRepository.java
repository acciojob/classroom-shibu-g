package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {

	Map<String,Student>student;
	Map<String,Teacher>teacher;
	Map<String,List<Student>>student_teacher;
	
	
	public StudentRepository() {
		student =new HashMap<>();
		teacher =new HashMap<>();
		student_teacher =new HashMap<>();
	}
	
public void addstudent(Student st) {
		student.put(st.getName(), st);
	}
	public void addteacher(Teacher tch) {
		teacher.put(tch.getName(),tch);
	}
	public void addstudent_teacher(String studentes,String teacher) {
		
		if(student_teacher.containsKey(teacher)){
			List<Student>students=(List<Student>) student.get(studentes);
			students.add(student.get(studentes));
		}else {
			List<Student>students=new ArrayList<>();
			students.add(student.get(studentes));
		}
	}
	
	public Student getstudentbyname(String name) {
		return student.get(name);
		
	}
	
	public Teacher getteacherbyname(String name) {
		return teacher.get(name);
		
	}
	public List<String>getStudentsByTeacherName(String name){
		List<String>students=new ArrayList<>();
		List<Student>st=student_teacher.get(name);
		for(Student sts:st) {
			students.add(sts.getName());
		}
return students;
	}
	public List<String>getallstudent(){
		List<String>students=new ArrayList<>();
		for(String a:student.keySet())
			students.add(a);
		return students;
			
		
	}
	public void deleteteacherbyname(String name) {
		if(student_teacher.containsKey(name)) {
			List<Student>students=student_teacher.get(name);
			for(Student st:students) {
				student.remove(st.getName());
			}
			teacher.remove(name);
			student_teacher.remove(name);
			
		}else {
			teacher.remove(name);
		}
		
	}
	public void deleteallteacher() {
		for(String name:teacher.keySet()) {
		if(student_teacher.containsKey(name)) {
			List<Student>students=student_teacher.get(name);
			for(Student st:students) {
				student.remove(st.getName());
			}
			teacher.remove(name);
			student_teacher.remove(name);
			
		}else {
			teacher.remove(name);
		}
	}
	}
	
}
