package edu.neu.samPrimarySchool.service;

import java.util.Collection;

import edu.neu.samPrimarySchool.model.Announcement;

public interface AnnouncementService {

	public void addAnnouncement(Announcement announcement);
	public Collection<Announcement> listAnnouncements();
	public Announcement getAnnouncement(int id);
}
