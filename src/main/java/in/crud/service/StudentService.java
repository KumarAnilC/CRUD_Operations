package in.crud.service;

import java.util.List;

import in.crud.entity.Student;

public interface StudentService {
	Integer saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getOneStudent(Integer id);
	
	void deleteStudent(Integer id);
	
	void updateStudent(Student student);
}
