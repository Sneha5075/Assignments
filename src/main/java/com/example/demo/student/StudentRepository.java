package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
	
@Query("SELECT s FROM Student s WHERE s.email=?1" )	
Optional<Student> findStudentByEmail(String email);


@Query("SELECT s FROM Student s ORDER BY s.dob desc")
List<Student> findStudentByDob();

@Query("SELECT s FROM Student s WHERE s.name=?1" )	
List<Student> findStudentByName(String name);





}
