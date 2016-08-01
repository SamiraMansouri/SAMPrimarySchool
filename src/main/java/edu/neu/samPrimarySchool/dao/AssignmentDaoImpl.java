package edu.neu.samPrimarySchool.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Assignment;
import edu.neu.samPrimarySchool.model.Teacher;

public class AssignmentDaoImpl extends DAO {

	public Assignment Create(String subject, String content,String goal, Date creationDate, Date deadline, int classId,
			Teacher teacher) throws AdException {
		Assignment assignment=null;
		try {
			begin();
			assignment = new Assignment(subject,content,goal,creationDate,deadline,classId,teacher);
			getSession().save(assignment);
			commit();

		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create assignment", e);
		}
		return assignment;
	}
	
	public boolean delete(int id) throws AdException {
		
		boolean result=true;
		Assignment assignment=new Assignment();
		assignment.setId(id);
		try {
			begin();
			getSession().delete(assignment);
			commit();

		} catch (HibernateException e) {
			rollback();
			result=false;
		}
		return result;
	}
	
	public Assignment edit(int id,String subject, String content,String goal, Date deadline) throws AdException {

	        try {
	            begin();
	            String x="update Assignment  set Subject = :subject," +
						"Content = :content,"+
						"Goal = :goal,"+
						"Deadline = :deadline "+
						"  WHERE Assignment_ID = :Assignment_ID";
	            Query query = getSession().createQuery(x);
	            query.setParameter("subject", subject);
	    		query.setParameter("content", content);
	    		query.setParameter("goal", goal);
	    		query.setParameter("deadline", deadline);
	    		query.setParameter("Assignment_ID", id);
	    		int result = query.executeUpdate();
	    		Assignment assignment=null;
	    		if (result==1) {
	    			assignment=showAssignment(id);
	    		}
	    		
	    		return assignment;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + id, e);
	        }
	}
	
	
	public List<Assignment> getClassAssignmetsList(int classId) throws AdException
	{
		try{
			begin();
			Query q=getSession().createQuery("from Assignment where Class_ID=:classId");
			q.setString("classId", String.valueOf(classId));
			List<Assignment> list=q.list();
			commit();
			return list;
		}
		catch(HibernateException e)
		{
			 rollback();
	            throw new AdException("Could not list the categories", e);	
		}
	}
	

	
	public List<Assignment> getAllAssignmets() throws AdException
	{
		try{
			begin();
			Query q=getSession().createQuery("from Assignment");
			List<Assignment> list=q.list();
			commit();
			return list;
		}
		catch(HibernateException e)
		{
			 rollback();
	            throw new AdException("Could not list the categories", e);	
		}
	}
	
	public Assignment showAssignment(int id) throws AdException
	{
		try{
			begin();
			Query q=getSession().createQuery("from Assignment where Assignment_ID=:id");
			q.setString("id", String.valueOf(id));
			Assignment assignemnt=(Assignment)q.uniqueResult();
			commit();
			return assignemnt;
		} catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + id, e);
        }
	}
	
	
}
