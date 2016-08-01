package edu.neu.samPrimarySchool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.samPrimarySchool.dao.AssignmentDaoImpl;
import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Assignment;
import edu.neu.samPrimarySchool.model.Teacher;

public class AssignmentServiceImpl {

	public Assignment Create(String subject, String content,String goal,Date creationDate, Date deadline, int classId, Teacher teacher) 
	{
		 AssignmentDaoImpl assignmentDaoImpl=new AssignmentDaoImpl();
		 Assignment assignment=null;
			try {
			assignment=assignmentDaoImpl.Create( subject,  content,goal, creationDate,  deadline,  classId,  teacher);
				
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return assignment;
			
		}
	
	public Assignment update(int id,String subject, String content,String goal, Date deadline) 
	{
		 AssignmentDaoImpl assignmentDaoImpl=new AssignmentDaoImpl();
		 Assignment assignment=null;
			try {
			assignment=assignmentDaoImpl.edit(id, subject, content, goal, deadline);
				
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return assignment;
			
		}
	
	public boolean delete(int id)
	{
		 AssignmentDaoImpl assignmentDaoImpl=new AssignmentDaoImpl();
		 boolean result=true;
			try {
			result=assignmentDaoImpl.delete(id);
				
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=false;
			}
			return result;
	}
	public Assignment showAssignment(int id)
	{
		AssignmentDaoImpl ADI=new AssignmentDaoImpl();
		Assignment assignment=null;
		try{
			assignment=ADI.showAssignment(id);
		}  catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assignment;
	}
	public List<Assignment> getAssignmetsList(int classId,String role)
	{
		
		 AssignmentDaoImpl assignmentDaoImpl=new AssignmentDaoImpl();
		List<Assignment> assignments=new ArrayList<Assignment>();
		try {
			if(role.equals("Teacher")||role.equals("Student")||role.equals("Parent"))
			{
				assignments=assignmentDaoImpl.getClassAssignmetsList( classId);

			}
			else if(role.equals("Admin")){
				assignments=assignmentDaoImpl.getAllAssignmets();
			}
			
			
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return assignments;
	}
}
