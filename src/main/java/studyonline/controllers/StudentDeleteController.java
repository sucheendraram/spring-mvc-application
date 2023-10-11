package studyonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studyonline.utils.StudentDBUtil;

@Controller
public class StudentDeleteController {

	@RequestMapping("/delete-student")
	public String deleteStudent(@RequestParam int studentId) {
		try {
			StudentDBUtil.deleteStudent(studentId);
			System.out.println("Delete successful!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/list-students";
	}
}
