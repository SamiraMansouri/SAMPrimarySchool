//package edu.neu.samPrimarySchool.dao;
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import edu.neu.samPrimarySchool.model.Announcement;
//
//@Repository
//public class AnnouncementDaoImpl implements AnnouncementDao{
//	
//	@Autowired
//	private SessionFactory sessionFacory;
//	
//	@Override
//	public void addAnnouncement(Announcement announcement){
//		sessionFacory.getCurrentSession().save(announcement);
//	}
//	
//	@Override
//	public List<Announcement> listAnnouncement()
//	{
//		return sessionFacory.getCurrentSession().createQuery("from Announcement").list();
//	}
//
//	@Override
//	public Announcement getAnnouncement(int id) {
//		// TODO Auto-generated method stub
//		return  (Announcement)sessionFacory.getCurrentSession().load(Announcement.class, id);
//	}
//
//}
