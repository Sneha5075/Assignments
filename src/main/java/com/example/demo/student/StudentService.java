package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


@Service
@AllArgsConstructor
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	

	public List<Student> getStudents()
	{
		
		 return studentRepository.findStudentByDob();
		 
		 
	}



	public void addNewStudent(Student student) {
		
		System.out.println(student);
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentByEmail.isPresent())
		{
			throw new IllegalStateException("email.teken");
		}
		studentRepository.save(student);
	}



	public void deleteStudent(long studentId) 
	{
	
		boolean exists= studentRepository.existsById(studentId);
		if(!exists)
		{
			throw new IllegalStateException("student with id "+studentId+"doesn't exists");
		}
		studentRepository.deleteById(studentId);
	}


	@Transactional
	public void updateStudent(long studentId, String name, String email) {
		
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("student with id "+studentId+"doesn't exists") );
		
		if(name!=null && name.length() > 0 && !Objects.equals(student.getName(),name))
		{
			student.setName(name);
		}
		
		if(email!=null && email.length() > 0 && !Objects.equals(student.getEmail(),email))
		{
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			
			if(studentOptional.isPresent())
			{
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}



	public List<Student> getStudentByName(String studentName) {
		
		 
		
				List<Student> findStudentByName = studentRepository.findStudentByName(studentName);
				if(findStudentByName.isEmpty())
				{
					throw new IllegalStateException("student with this name doesn't exists");
				}
				return findStudentByName;
	}



	
	
}
