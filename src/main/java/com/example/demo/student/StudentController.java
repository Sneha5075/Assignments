package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="api/v1/student")
@AllArgsConstructor
public class StudentController {
	
	private final StudentService studentService;
	
	


	@GetMapping
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
	
	@GetMapping(path="{studentName}")
	public List<Student> getStudentByName(@PathVariable("studentName") String studentName)
	{
		return studentService.getStudentByName(studentName);
	}
	
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student)
	{
		 studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") long studentId)
	{
		studentService.deleteStudent(studentId);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudent(@PathVariable("studentId") long studentId,
								@RequestParam(required=false) String name,
								@RequestParam(required=false) String email)
								
	{
		studentService.updateStudent(studentId,name,email);
	}

}
