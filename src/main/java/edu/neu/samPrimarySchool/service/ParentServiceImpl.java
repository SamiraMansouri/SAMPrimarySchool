package edu.neu.samPrimarySchool.service;

import edu.neu.samPrimarySchool.dao.ParentDaoImpl;
import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Parent;

public class ParentServiceImpl {
	
	ParentDaoImpl parentDaoImpl=new ParentDaoImpl();
	
	public Parent getParent(int parentId)
	{
		Parent parent=new Parent();
		try {
			parent = parentDaoImpl.getParent(parentId);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parent;
		
	}

}
