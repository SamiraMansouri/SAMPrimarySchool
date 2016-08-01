package edu.neu.samPrimarySchool.service;

import java.util.ArrayList;

import edu.neu.samPrimarySchool.dao.ClassroomDaoImpl;
import edu.neu.samPrimarySchool.dao.ParentDaoImpl;
import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.Student;

public class ClassroomServiceImpl {
	
	 ClassroomDaoImpl classroomDaoImpl=new ClassroomDaoImpl();
	

	
	public Classroom getParentClassroom(int parentId) throws AdException
	{
		ParentDaoImpl parentDaoImpl=new ParentDaoImpl();
		Student student=(Student) parentDaoImpl.getParent(parentId).getStudent();
		Classroom classroom=student.getClassroom();
		return classroom;
	}
	
	public Classroom findTeacherClass(int teacherId) throws AdException
	{
		
		Classroom classroom=classroomDaoImpl.findTeacherClass(teacherId);
		return classroom;
	}
	
	public ArrayList<Student> classroomStudents(int id) throws AdException 
	{
		
		 ArrayList<Student> students=  (ArrayList<Student>) classroomDaoImpl.classroomStudents(id);
		 return students;
	}
	


}
