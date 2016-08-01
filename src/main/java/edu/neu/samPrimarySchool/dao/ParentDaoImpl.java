package edu.neu.samPrimarySchool.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Parent;

public class ParentDaoImpl extends DAO {
	
	public Parent getParent(int parentId) throws AdException
	{
	       try {
	            begin();
	            Query q = getSession().createQuery("from Parent where User_Id = :parentId");
	            q.setParameter("parentId", parentId);
	            Parent parent = (Parent) q.uniqueResult();
	            commit();
	            return parent;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + parentId, e);
	        }
	}

}
