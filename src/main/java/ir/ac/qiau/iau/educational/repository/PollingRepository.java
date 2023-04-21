package ir.ac.qiau.iau.educational.repository;

import ir.ac.qiau.iau.educational.model.Polling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingRepository extends JpaRepository<Polling, Long> {
}
