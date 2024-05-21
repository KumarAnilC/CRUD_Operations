package in.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
