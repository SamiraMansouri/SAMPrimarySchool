package edu.neu.samPrimarySchool.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import edu.neu.samPrimarySchool.model.Assignment;
import edu.neu.samPrimarySchool.model.Classroom;
import edu.neu.samPrimarySchool.model.Teacher;
import edu.neu.samPrimarySchool.model.User;
import edu.neu.samPrimarySchool.service.AssignmentServiceImpl;

@Controller
public class AssignmentController {
	
	
	//Add New Assignment
	@RequestMapping(value = "/AddAssignment.htm", method = RequestMethod.POST)
	public ModelAndView AddNewAssignment(HttpServletRequest request,HttpServletResponse response) throws AdException   {

		ModelAndView mv=new ModelAndView();
		String subject=request.getParameter("subject");
		String dateInString = request.getParameter("date");

		Date creationDate=new Date();
		
		String content=request.getParameter("description");
		String goal=request.getParameter("goal");
		
		HttpSession session=request.getSession();
		Classroom classroom=(Classroom) session.getAttribute("classroom");
		User user=(User) session.getAttribute("user");
		Teacher teacher=(Teacher) user;
		String message=checkInput(subject, content, dateInString);
		Assignment assignment=new Assignment();
		if(message==null )
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date deadline=new Date();
			try {

				deadline = formatter.parse(dateInString);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			AssignmentServiceImpl assignmentServiceImpl=new AssignmentServiceImpl();
			assignment=assignmentServiceImpl.Create(subject, content,goal, creationDate, deadline,classroom.getId() ,teacher);
			if (assignment!=null) {
				message="success";
			}
			else{
				message="there is some problem in connection please try again";
				
			}
		}
		assignment.setContent(content);
		assignment.setCreationDate(creationDate);
		assignment.setDeadline(new Date());
		assignment.setSubject(subject);
		
		mv.setViewName("AddNewAssignment");
		mv.addObject("message", message);
		mv.addObject("assignment",assignment);
		
		return mv;
	}

	//show list of assignments for teacher and admin	
	@RequestMapping(value="/AssignmentsList",method=RequestMethod.GET)
	public ModelAndView AssignmentsList(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		
		 HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Classroom classroom=(Classroom) session.getAttribute("classroom");
		List<Assignment> assignments=new ArrayList<Assignment>();
		
		AssignmentServiceImpl assignmentServiceImpl=new AssignmentServiceImpl();
		assignments= assignmentServiceImpl.getAssignmetsList(classroom.getId(), user.getRole());
		mv.addObject("assignmentsList",assignments);
		
		if (user.getRole().equals("Teacher") ||user.getRole().equals("Admin")  ) {
			mv.setViewName("AssignmentsList");
		}
		else if(user.getRole().equals("Student") ||user.getRole().equals("Parent"))
		{
			mv.setViewName("MyAssignments");
		}
		
		return mv;
		
	}
	
	
	//delete an assignment	
	@RequestMapping(value="/deleteAssignment")
	public ModelAndView deleteAssignment(@RequestParam("values") List<Integer> assignmentIds,HttpServletRequest request,
									HttpServletResponse response) 
	{
		for (Integer id : assignmentIds) {
			AssignmentServiceImpl assignmentServiceImpl=new AssignmentServiceImpl();
			boolean result=assignmentServiceImpl.delete(id);
		}
		
		ModelAndView mv=new ModelAndView();
		
		 HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Classroom classroom=(Classroom) session.getAttribute("classroom");
		List<Assignment> assignments=new ArrayList<Assignment>();
		
		AssignmentServiceImpl assignmentServiceImpl=new AssignmentServiceImpl();
		assignments= assignmentServiceImpl.getAssignmetsList( classroom.getId(), user.getRole());
		mv.setViewName("AssignmentsList");
		mv.addObject("assignmentsList",assignments);
		return mv;
	}
	
	//Show an Assignment
	@RequestMapping(value="/ShowAssignment.htm")
	public ModelAndView showAssignment(@RequestParam("assignmentId") int id,HttpServletRequest request,
									HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		AssignmentServiceImpl ASI=new AssignmentServiceImpl();
		Assignment assignment=ASI.showAssignment(id);
		mv.addObject(assignment);
		 HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");

		if (user.getRole().equals("Teacher") ||user.getRole().equals("Admin")  ) {
			mv.setViewName("EditAssignment");
		}
		else if(user.getRole().equals("Student") ||user.getRole().equals("Parent"))
		{
			mv.setViewName("MyAssignmentDetail");
		}
		
		return mv;
	}
	
	//edit an Assignment
	@RequestMapping(value="/EditAssignment",method=RequestMethod.POST)
	public ModelAndView editAssignment(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv=new ModelAndView();
		int assignmentId=Integer.parseInt(request.getParameter("id")) ;
		String subject=request.getParameter("subject");
		String dateInString = request.getParameter("date");
		
		String content=request.getParameter("description");
		String goal=request.getParameter("goal");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date deadline=new Date();
		try {

			deadline = formatter.parse(dateInString);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		AssignmentServiceImpl assignmentServiceImpl=new AssignmentServiceImpl();
		Assignment assignment=assignmentServiceImpl.update( assignmentId, subject, content, goal, deadline);
		String message=null;
		if (assignment!=null) {
			message="success";
		}
		else{
			message="there is some problem in connection please try again";
			
		}

	
	mv.setViewName("EditAssignment");
	mv.addObject("message", message);
	mv.addObject("assignment",assignment);
	
	return mv;
		
	}
	
	
	private String checkInput(String subject,String description,String deadline)
	{
		String message=null;
			if(subject==null || subject.trim().equals(""))
			{
				message="please fill the Subject";
			}
			if(description==null || description.trim().equals(""))
			{
				if(message==null)
				{
					message="please fill the Description";
				}
				else 
				{
					message +=" and Description";
				}
			}
			if(deadline==null || deadline.equals(""))
			{
				if(message==null)
			{
				message="please select the Deadline";
			}
			else 
			{
				message +=" and select the Deadline";
			}
				}
		return message;
	}


}//AuthenticationSuccessHandler



