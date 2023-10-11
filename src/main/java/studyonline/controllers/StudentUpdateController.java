package studyonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studyonline.classes.Student;
import studyonline.utils.StudentDBUtil;

@Controller
public class StudentUpdateController {

	public StudentUpdateController() {
		System.out.println("Update controller!!! ");
	}

	@RequestMapping("/load-student")
	public String loadStudent(@RequestParam int studentId, Model m) {
		try {

			Student studentData = StudentDBUtil.getStudentDetailsUsingId(studentId);
			m.addAttribute("SINGLE_STUDENT_DATA", studentData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/WEB-INF/views/student-update-page.jsp";
	}

	@RequestMapping("/update-student")
	public String updateStudent(@RequestParam int studentId, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam int age, @RequestParam String email,
			@RequestParam String department, @RequestParam String grade, @RequestParam String regNo, Model model) {
		try {
			Student updatedStudent = new Student(studentId, firstName, lastName, age, email, department, grade, regNo);
			System.out.println("UPDATED STUDENT " + updatedStudent);
			StudentDBUtil.updateStudent(updatedStudent);
			System.out.println("Update Successful");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/list-students";
	}
}
