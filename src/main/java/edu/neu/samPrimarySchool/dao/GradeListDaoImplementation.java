package edu.neu.samPrimarySchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Grade;
import edu.neu.samPrimarySchool.model.GradeList;

public class GradeListDaoImplementation extends DAO {

	public GradeList Create(GradeList gradelist, List<Grade> grades) throws AdException {

		try {
			begin();
			gradelist.setGrade(grades);
			int id = (Integer) getSession().save(gradelist);
			gradelist.setId(id);
			for (Grade grade : grades) {
				grade.setGradeList(gradelist);
				getSession().save(grade);
			}

			commit();
			return gradelist;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not update gradelist", e);

		}
	}

	public boolean delete(int id) throws AdException {

		boolean result = true;
		GradeList gradeList = new GradeList();
		gradeList.setId(id);
		try {
			begin();
			getSession().delete(gradeList);
			commit();

		} catch (HibernateException e) {
			rollback();
			result = false;
		}

		try {
			begin();
			String x = "delete from Grade where Grade_List_ID =:Grade_List_ID";
			Query queryGL = getSession().createQuery(x);
			queryGL.setParameter("Grade_List_ID", id);
			queryGL.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			result = false;
		}

		return result;
	}

	public int edit(GradeList gradelist, List<Grade> grades) throws AdException {

		int resultGL = 0;
		try {
			begin();
			String x = "update GradeList  set " + "Date_of_Grade_List = :Date_of_Grade_List," + "Scale = :Scale, "
					+ "Subject = :Subject, " + "Description = :Description where Grade_List_ID = :Grade_List_ID";
			Query queryGL = getSession().createQuery(x);
			queryGL.setParameter("Grade_List_ID", gradelist.getId());
			queryGL.setParameter("Description", gradelist.getDescription());
			queryGL.setParameter("Subject", gradelist.getSubject());
			queryGL.setParameter("Scale", gradelist.getScale());
			queryGL.setParameter("Date_of_Grade_List", gradelist.getDate());
			resultGL = queryGL.executeUpdate();

			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not create gradelist", e);

		}
		for (Grade grade : grades) {
		
				try {
					begin();
					String q = "update Grade  set " + "Value = :Value, " + "Description = :Description "
							+ "  WHERE (Student_ID = :Student_ID and Grade_List_ID = :Grade_List_ID)";
					Query queryG = getSession().createQuery(q);
					queryG.setParameter("Value", grade.getValue());
					queryG.setParameter("Description", grade.getDescription());
					queryG.setParameter("Student_ID", grade.getStudent().getiD());
					queryG.setParameter("Grade_List_ID", gradelist.getId());

					resultGL = queryG.executeUpdate();
					commit();
				} catch (HibernateException e) {
					rollback();
					throw new AdException("Could not create gradelist", e);

				}
			
			
		}

		return resultGL;

	}

	public Grade getGrade(int studentId, int gradeListId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Grade where Student_ID=:StudentId and Grade_List_ID=:gradeListId");
			q.setString("StudentId", String.valueOf(studentId));
			q.setString("gradeListId", String.valueOf(gradeListId));
			Grade grade = (Grade) q.uniqueResult();
			commit();
			return grade;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get the grade", e);

		}
	}

	public List<GradeList> getClassGradesList(int classId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from GradeList where Class_ID=:classId");
			q.setString("classId", String.valueOf(classId));
			List<GradeList> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the gradesList", e);
		}
	}

	public List<GradeList> getAllGradesList() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from GradeList");
			List<GradeList> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the Grade Lists", e);
		}
	}

	public GradeList showGradeList(int id) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from GradeList where Grade_List_ID=:id");
			q.setString("id", String.valueOf(id));
			GradeList gradeList = (GradeList) q.uniqueResult();

			q = getSession().createQuery("from Grade where Grade_List_ID=:id");
			q.setString("id", String.valueOf(id));
			List<Grade> grades = q.list();
			gradeList.setGrade(grades);
			commit();
			return gradeList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get Grade_List_ID " + id, e);
		}
	}

	public List<Grade> getMyGrades(int classId, int userID) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Grade where Student_ID=:Student_ID");
			q.setString("Student_ID", String.valueOf(userID));
			List<Grade> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the grades", e);
		}
	}
}
