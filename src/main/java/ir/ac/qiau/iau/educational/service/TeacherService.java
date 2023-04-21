package ir.ac.qiau.iau.educational.service;

import ir.ac.qiau.iau.educational.model.Teacher;
import ir.ac.qiau.iau.educational.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.getById(id);
    }

    public void delete(Long id){
        teacherRepository.deleteById(id);
    }
}
