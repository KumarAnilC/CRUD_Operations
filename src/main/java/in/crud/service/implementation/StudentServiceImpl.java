package in.crud.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crud.entity.Student;
import in.crud.repository.StudentRepository;
import in.crud.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student student) {
		return repo.save(student).getId();
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public void updateStudent(Student student) {
		repo.save(student);
	}

	@Override
	public Student getOneStudent(Integer id) {
		return repo.findById(id).get();
	}

}
