package studyonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studyonline.classes.Student;
import studyonline.utils.StudentDBUtil;

@Controller
public class StudentAddController {

	@RequestMapping("/add-student")
	public String addStudent() {
		return "/WEB-INF/views/student-add-page.jsp";
	}

	@RequestMapping("/save-student")
	public String saveStudentData(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,
			@RequestParam String email, @RequestParam String department, @RequestParam String grade,
			@RequestParam String regNo, Model model) {
		try {
			System.out.println("Saving student data!!!");
			model.addAttribute("first_name", firstName);
			model.addAttribute("last_name", lastName);
			model.addAttribute("age", age);
			model.addAttribute("email", email);
			model.addAttribute("department", department);
			model.addAttribute("grade", grade);
			model.addAttribute("regNo", regNo);
			Student s1 = new Student(firstName, lastName, age,email, department, grade, regNo);
			StudentDBUtil.addStudent(s1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/list-students";
	}
}
