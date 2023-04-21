package ir.ac.qiau.iau.educational.service;

import ir.ac.qiau.iau.educational.model.Student;
import ir.ac.qiau.iau.educational.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
         return studentRepository.findAll();
    }

    @Transactional
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.getById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
