//package edu.neu.samPrimarySchool.service;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import edu.neu.samPrimarySchool.dao.AnnouncementDao;
//import edu.neu.samPrimarySchool.model.Announcement;
//
//@Service
//public class AnnouncementServiceImpl implements AnnouncementService {
//
//	@Autowired
//	private AnnouncementDao announcementDao;
//	
//	@Override
//	@Transactional
//	public void addAnnouncement(Announcement announcement) {
//		announcementDao.addAnnouncement(announcement);
//
//	}
//
//	@Override
//	@Transactional
//	public Collection<Announcement> listAnnouncements() {
//		return announcementDao.listAnnouncement();
//	}
//
//	@Override
//	@Transactional
//	public Announcement getAnnouncement(int id) {
//		return announcementDao.getAnnouncement(id);
//	}
//
//}
