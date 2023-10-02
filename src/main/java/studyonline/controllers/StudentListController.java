package studyonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentListController {
	
	@RequestMapping("/list-students")
	public String getStudentListPage() {
		System.out.println("Student list page is called!!");
		return "WEB-INF/views/students-list-page.jsp";
	}
}
