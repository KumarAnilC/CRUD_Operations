package in.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.crud.entity.Student;
import in.crud.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/register")
	public String showRegistration() {
		return "Registration";
	}
	
	@PostMapping("/save")
	public String save(
			@ModelAttribute Student student,
			Model model
			) 
	{
		Integer id = service.saveStudent(student);
		String message = "Student '"+id+"' created";
		model.addAttribute("message", message);
		return "Registration";
	}
	
	@GetMapping("/all")
	public String getAll(
			@RequestParam(required = false) String message,
			Model model
			) 
	{
		List<Student> list = service.getAllStudents();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "Students";
	}
	
	@GetMapping("/delete")
	public String delete(
			@RequestParam Integer id,
			RedirectAttributes attributes
			) 
	{
		service.deleteStudent(id);
		attributes.addAttribute("message", "Student '"+id+"' deleted");
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam Integer id,
			Model model
			) 
	{
		Student student = service.getOneStudent(id);
		model.addAttribute("student", student);
		return "Edit";
	}
	
	@PostMapping("/update")
	public String update(
			@ModelAttribute Student student,
			RedirectAttributes attributes
			) 
	{
		service.updateStudent(student);
		String message = "Student '"+student.getId()+"' Updated";
		attributes.addAttribute("message", message);
		return "redirect:all";
	}
}
