package edu.neu.samPrimarySchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.Student;

public class ClassroomDaoImpl extends DAO{
	
	 public Classroom findTeacherClass(int id)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Classroom where USER_ID=:id ");
	            q.setParameter("id", id);
	            Classroom classroom = (Classroom) q.uniqueResult();
	            commit();
	            return classroom;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + id, e);
	        }
	    }
	 
	 public List<Student> classroomStudents(int id)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Student where Class_ID=:id ");
	    		q.setString("id", String.valueOf(id));
				List<Student> list=q.list();
				commit();
				return list;
			}
			catch(HibernateException e)
			{
				 rollback();
		            throw new AdException("Could not list the students of a class", e);	
			}
	 }
}
