package studyonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentAddController {

	public StudentAddController() {
		System.out.println("Student Add controller called!");
	}

	@RequestMapping("/add-student")
	public String addStudent() {
		return "/WEB-INF/views/student-add-page.jsp";
	}

	@RequestMapping("/save-student")
	public String saveStudentData(@RequestParam String firstName, @RequestParam String lastName, Model model) {
		System.out.println(firstName + "==" + lastName);
		System.out.println("Saving student data!!!");
		model.addAttribute("first_name", firstName);
		model.addAttribute("last_name", lastName);
		System.out.println(model);
		return "/WEB-INF/views/display-added-student.jsp";
	}
}
