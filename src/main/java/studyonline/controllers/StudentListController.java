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
		List<Student> allStudents = StudentDBUtil.getAllStudents();
		m.addAttribute("student_list", allStudents);
		return "WEB-INF/views/students-list-page.jsp";
	}
}
