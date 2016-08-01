package edu.neu.samPrimarySchool.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.Grade;
import edu.neu.samPrimarySchool.model.GradeList;
import edu.neu.samPrimarySchool.model.Student;
import edu.neu.samPrimarySchool.model.User;
import edu.neu.samPrimarySchool.service.GradeListServiceImplementation;

@Controller
public class GradesController {
	//Add Gradelist

	
	@RequestMapping(value = "/AddGradeList.htm", method = RequestMethod.POST)
	public ModelAndView AddGradeList(HttpServletRequest req, HttpServletResponse resp) throws AdException {
		ModelAndView mv = new ModelAndView();
		String subject = req.getParameter("subject");
		String dateInString = req.getParameter("date");
		String description = req.getParameter("description");
		String scale = req.getParameter("scale");

		 HttpSession session = req.getSession();
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		User user = (User) session.getAttribute("user");
		List<Grade> grades = new ArrayList<Grade>();

		for (Student studnet : classroom.getStudent()) {
			Grade grade = new Grade();
			Student st = studnet;
			grade.setStudent(st);
			String studentId = String.valueOf(st.getiD());
			String gradeValue = req.getParameter(studentId);
			grade.setValue(gradeValue);
			String id = "gd" + studentId;
			String desc = req.getParameter(id);
			grade.setDescription(desc);

			grades.add(grade);

		}

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {

			date = formatter.parse(dateInString);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		String message = "";

		GradeList gradeList = new GradeList(subject, description, scale, date, classroom.getId(), user);

		GradeListServiceImplementation gradeListSI = new GradeListServiceImplementation();
		gradeList = gradeListSI.create(gradeList, grades);
		if (gradeList.getId() > 0) {
			message = "success";
		} else {
			message = "there is some problem in connection please try again";

		}
		mv.addObject("students", classroom.getStudent());
		mv.addObject("message", message);
		mv.setViewName("EditGradeList");
		mv.addObject("grades", grades);
		mv.addObject(gradeList);
		return mv;
	}
	// Edit GradeList Teacher
	@RequestMapping(value="/EditGradeList",method=RequestMethod.POST)
	public ModelAndView EditGradeList(HttpServletRequest req,HttpServletResponse resp) throws AdException
	{
		ModelAndView mv = new ModelAndView();
		String subject = req.getParameter("subject");
		String dateInString = req.getParameter("date");
		String description = req.getParameter("description");
		String scale = req.getParameter("scale");
		int id=Integer.parseInt(req.getParameter("id"));

		 HttpSession session = req.getSession();
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		User user = (User) session.getAttribute("user");
		List<Grade> grades = new ArrayList<Grade>();

		for (Student studnet : classroom.getStudent()) {
			Grade grade = new Grade();
			Student st = studnet;
			grade.setStudent(st);
			String studentId = String.valueOf(st.getiD());
			String gradeValue = req.getParameter(studentId);
			grade.setValue(gradeValue);
			String Gid = "gd" + studentId;
			String desc = req.getParameter(Gid);
			grade.setDescription(desc);

			grades.add(grade);

		}

		SimpleDateFormat parseFormat = 
			    new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		Date date = null;
		try {

			date = parseFormat.parse(dateInString);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
			String result = format.format(date);
			date=format.parse(result);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String message = "";

		GradeList gradeList = new GradeList( id,subject,description, scale, date, classroom.getId(), user);

		GradeListServiceImplementation gradeListSI = new GradeListServiceImplementation();
		int reslut = gradeListSI.update(gradeList, grades);
		if (reslut!=0) {
			message = "success";
		} else {
			message = "there is some problem in connection please try again";

		}
		mv.addObject("students", classroom.getStudent());
		mv.addObject("message", message);
		mv.setViewName("EditGradeList");
		mv.addObject("grades", grades);
		mv.addObject(gradeList);
		return mv;
	}
	
	//show list of assignments for teacher and admin	
	@RequestMapping(value="/GradeLists",method=RequestMethod.GET)
	public ModelAndView GradeListsList(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("user");
			Classroom classroom=(Classroom) session.getAttribute("classroom");
			List<GradeList> gradeLists=new ArrayList<GradeList>();
			
			GradeListServiceImplementation gradeListServiceImpl=new GradeListServiceImplementation();
			gradeLists= gradeListServiceImpl.getGradeLists(classroom.getId(), user.getRole(),user.getiD());
			mv.addObject("gradeLists",gradeLists);
			
			if (user.getRole().equals("Teacher") ||user.getRole().equals("Admin") ||user.getRole().equals("Advisor") ) {
				mv.setViewName("GradeLists");
			}
			else if(user.getRole().equals("Student") ||user.getRole().equals("Parent"))
			{
				mv.setViewName("GradeLists");
			}
			
			return mv;
			
		}

	@RequestMapping(value="/ShowGradeList",method=RequestMethod.GET)
	public ModelAndView ShowGradeList(@RequestParam int glId,HttpServletRequest req,HttpServletResponse response) throws AdException
	{
		ModelAndView mv=new ModelAndView();
		GradeListServiceImplementation glSI=new GradeListServiceImplementation();
		GradeList gl=new GradeList();
		gl=glSI.showGradeList(glId);
		mv.addObject("gradeList",gl);
		mv.addObject("grades", gl.getGrade());
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");

		if (user.getRole().equals("Teacher") ) {
			mv.setViewName("EditGradeList");
		}
		else if(user.getRole().equals("Advisor"))
		{
			mv.setViewName("ShowGradeList");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/deletegradeLists")
	public ModelAndView deleteAssignment(@RequestParam("values") List<Integer> gradeListIds,HttpServletRequest request,
									HttpServletResponse response) throws AdException 
	{
		for (Integer id : gradeListIds) {
			GradeListServiceImplementation gradeListsServiceImpl=new GradeListServiceImplementation();
			boolean result=gradeListsServiceImpl.deleteGradeList(id);
		}
		
		ModelAndView mv=new ModelAndView();
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Classroom classroom=(Classroom) session.getAttribute("classroom");
		List<GradeList> gradeLists=new ArrayList<GradeList>();
		
		GradeListServiceImplementation gradeListServiceImpl=new GradeListServiceImplementation();
		gradeLists= gradeListServiceImpl.getGradeLists(classroom.getId(), user.getRole(),user.getiD());
		mv.setViewName("GradeLists");
		mv.addObject("gradeLists",gradeLists);
		return mv;
	}
	
	@RequestMapping(value="/MyGrades",method=RequestMethod.GET)
	public ModelAndView showMyGrades(HttpServletRequest req,HttpServletResponse res) throws AdException
	{
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");
		Classroom classroom=(Classroom) session.getAttribute("classroom");
		
		GradeListServiceImplementation glSI=new GradeListServiceImplementation();
		List<Grade> grades= new ArrayList<Grade>();

		if (user.getRole().equals("Student") ) {
			grades=glSI.showMyGrades(classroom.getId(), user.getiD());
			
		}
		else if(user.getRole().equals("Parent"))
		{
			grades=glSI.showMyChildGrades(classroom.getId(), user.getiD());
		}
		mv.addObject("grades", grades);
		mv.setViewName("MyGrades");
		return mv;
	}
}
