package studyonline.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studyonline.classes.Student;
import studyonline.utils.StudentDBUtil;

@Controller
public class StudentListController {

	@RequestMapping("/list-students")
	public String getStudentListPage(Model m) throws Exception {
		System.out.println("Student list page is called!!");
		List<Student> allStudents = StudentDBUtil.getAllStudents();
		System.out.println("All STUDENTS" + allStudents);
		m.addAttribute("student_list",allStudents);
		System.out.println("<PDE"+m);
		return "WEB-INF/views/students-list-page.jsp";
	}
}
