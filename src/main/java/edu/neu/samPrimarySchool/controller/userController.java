package edu.neu.samPrimarySchool.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.Student;
import edu.neu.samPrimarySchool.model.User;
import edu.neu.samPrimarySchool.service.ClassroomServiceImpl;
import edu.neu.samPrimarySchool.service.UserServiceImpl;


@Controller
public class userController {

	@RequestMapping(value = "/homePage.htm", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws AdException   {

		String username=request.getParameter("username");
		String password=request.getParameter("pwd");
		ModelAndView mv=new ModelAndView();
	
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		User user=userServiceImpl.findUser(username,password);
		
		if(user!=null)
		{
			Classroom classroom=new Classroom();
			ClassroomServiceImpl classroomServiceImpl=new ClassroomServiceImpl();
			if(user.getRole().equals("Student"))
			{
				Student st=(Student)user;
				classroom=st.getClassroom();
			}
			else if(user.getRole().equals("Teacher"))
			{
				classroom= classroomServiceImpl.findTeacherClass(user.getiD());
				
			}
			if(user.getRole().equals("Parent"))
			{
				classroom=classroomServiceImpl.getParentClassroom(user.getiD());
			}
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("classroom", classroom);
			mv.setViewName("homePage");
		}
		else
		{
			mv.setViewName("login");
		}
		return mv;
	}
}
