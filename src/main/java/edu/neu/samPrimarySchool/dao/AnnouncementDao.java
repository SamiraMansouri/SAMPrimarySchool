package edu.neu.samPrimarySchool.dao;

import java.util.List;

import edu.neu.samPrimarySchool.model.Announcement;

public interface AnnouncementDao {

	public void addAnnouncement(Announcement announcement);
	public List<Announcement> listAnnouncement();
	public Announcement getAnnouncement(int id);
}
