package edu.neu.samPrimarySchool.service;

import java.util.ArrayList;
import java.util.List;

import edu.neu.samPrimarySchool.dao.GradeListDaoImplementation;
import edu.neu.samPrimarySchool.dao.ParentDaoImpl;
import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Grade;
import edu.neu.samPrimarySchool.model.GradeList;
import edu.neu.samPrimarySchool.model.Student;

public class GradeListServiceImplementation {

	 GradeListDaoImplementation gradelistDaoImpl=new GradeListDaoImplementation();
		
	public GradeList create(GradeList gradelist,List<Grade> grades) throws AdException
	{

		gradelist=gradelistDaoImpl.Create(gradelist,grades);
		return gradelist;
	}
	
	public int update(GradeList gradelist,List<Grade> grades) throws AdException
	{

		int result =gradelistDaoImpl.edit(gradelist,grades);
		return result;
	}
	
	public List<GradeList> getGradeLists(int classID, String role, int userID)
	{
		List<GradeList> gradeLists=new ArrayList<GradeList>();
		try {
			if(role.equals("Teacher"))
			{
				gradeLists=gradelistDaoImpl.getClassGradesList(classID);

			}
			else if(role.equals("Admin") ||role.equals("Advisor")){
				gradeLists=gradelistDaoImpl.getAllGradesList();
			}
			
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return gradeLists;
	}

	public List<Grade> showMyGrades(int classId,int studentsId) throws AdException
	{
		List<Grade> grades=gradelistDaoImpl.getMyGrades(classId, studentsId);
		return grades;
		
	}
	
	public List<Grade> showMyChildGrades(int classId,int parentId) throws AdException
	{
		ParentDaoImpl parentDaoImpl=new ParentDaoImpl();
		Student student=(Student) parentDaoImpl.getParent(parentId).getStudent();
		List<Grade> grades=gradelistDaoImpl.getMyGrades(classId, student.getiD());
		return grades;
		
	} 
	public GradeList showGradeList(int id) throws AdException
	{
		GradeList gradelist=gradelistDaoImpl.showGradeList(id);
		return gradelist;
	}
	
	public boolean deleteGradeList(int id) throws AdException
	{
		boolean result=gradelistDaoImpl.delete(id);
		return result;
	}
}
