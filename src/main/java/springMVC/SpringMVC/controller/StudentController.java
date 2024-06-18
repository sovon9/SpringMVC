package springMVC.SpringMVC.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springMVC.SpringMVC.model.Student;

@Controller
@RequestMapping("/studentAPI")
public class StudentController {

	@Value("${student.gendervalue}")
	private List<String> genders;
	
	//http://localhost:8080/studentAPI/form
	@GetMapping(value="/form")
	public String showForm(Model model)
	{
		model.addAttribute("student", new Student());
		model.addAttribute("genderlist", genders);
		return "studentform";
	}
	
	@PostMapping("/submitStudent")
	public String showStudentConfirmation(@ModelAttribute("student") Student student)
	{
		System.out.println("showStudentConfirmation ==================== "+student.getGender());
		return "studentdata";
	}
	
	@PostMapping("/submitFinalStudent")
	public String showConfirmedStudent(@ModelAttribute("student") Student student)
	{
		System.out.println("==================== "+student.getGender());
		return "studentdatafinal";
	}
	
	@ModelAttribute("countryoptions")
	public List<String> countryList()
	{
		return Arrays.asList("India","Japan","USA");
	}
	
}
