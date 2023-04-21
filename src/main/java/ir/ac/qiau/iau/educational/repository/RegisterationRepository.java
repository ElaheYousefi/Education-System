package ir.ac.qiau.iau.educational.repository;

import ir.ac.qiau.iau.educational.model.PollingKey;
import ir.ac.qiau.iau.educational.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RegisterationRepository  extends JpaRepository<Registration, PollingKey> {

    @Query("select reg from Registration reg where reg.student.stdCode= ?1")
    List<Registration> findByStudentId(Long studentId);
}

