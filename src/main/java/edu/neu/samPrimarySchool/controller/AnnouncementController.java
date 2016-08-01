package edu.neu.samPrimarySchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.samPrimarySchool.model.Announcement;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.User;
import edu.neu.samPrimarySchool.service.AnnouncementService;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AnnouncementController {
	
//	@Autowired
//    public HttpHttpSession session session;
//	
//	@Autowired
//	AnnouncementService announcementService;
//	
//	@RequestMapping(value="addAnnouncement_Teacher",method=RequestMethod.POST)
//	public String AddAnnouncement(@ModelAttribute("announcement") Announcement announcement){
//	
//
//		User teacher=(User) session.getAttribute("user");
//		Classroom classroom=(Classroom)session.getAttribute("classroom");
//		announcement.setClassId(classroom.getId());
//		announcement.setUser_ID(teacher.getiD());
//		announcement.setCreationDate(new Date());
//
//		announcementService.addAnnouncement(announcement);
//		
//		return "redirect:/SAMPrimarySchool/addAnnouncement_Teacher";
//	}
//	
//	@RequestMapping(value="/addAnnouncement_Teacher",method=RequestMethod.GET)
//	public String ADDAnnouncement(Model model)
//	{
//		model.addAttribute("announcement",new Announcement());
//		return "ADDAnnouncement_Teacher";
//	}

}
