package edu.neu.samPrimarySchool.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.samPrimarySchool.service.ClassroomServiceImpl;
import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.Student;

@Controller
public class NavigationControllers {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView showHome()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView goHome()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/aboutUs",method=RequestMethod.GET)
	public ModelAndView showAboutUs()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("aboutUs");
		return mv;
	}

	@RequestMapping(value="/gallery",method=RequestMethod.GET)
	public ModelAndView showGallery()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("gallery");
		return mv;
	}
	
	@RequestMapping(value="/application",method=RequestMethod.GET)
	public ModelAndView showApplication()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("application");
		return mv;
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView showContact()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView showLogin()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/AddNewAssignment",method=RequestMethod.GET)
	public ModelAndView AddNewAssignement(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("AddNewAssignment");
		return mv;
	}
	
	
	@RequestMapping(value="/AddGradeList",method=RequestMethod.GET)
	public ModelAndView showAddGradeList(HttpServletRequest request,HttpServletResponse response) throws AdException
	{
		ModelAndView mv= new ModelAndView();
		HttpSession session=request.getSession();
		Classroom classroom=(Classroom) session.getAttribute("classroom");
		ClassroomServiceImpl CSI=new ClassroomServiceImpl();
		ArrayList<Student> students=new ArrayList<Student>();
		students=CSI.classroomStudents(classroom.getId());

		System.out.println(students.size());
		mv.addObject("students", students);
		mv.setViewName("AddGradeList");
		return mv;
	}
	
	@RequestMapping(value="/EditGradeList",method=RequestMethod.GET)
	public ModelAndView showEditGradeList(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("EditGradeList");
		return mv;
	}
	

}
