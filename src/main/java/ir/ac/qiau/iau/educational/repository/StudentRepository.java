package ir.ac.qiau.iau.educational.repository;

import ir.ac.qiau.iau.educational.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
