package ir.ac.qiau.iau.educational.repository;

import ir.ac.qiau.iau.educational.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
