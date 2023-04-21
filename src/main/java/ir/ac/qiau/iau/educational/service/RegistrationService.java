package ir.ac.qiau.iau.educational.service;

import ir.ac.qiau.iau.educational.model.Registration;
import ir.ac.qiau.iau.educational.repository.RegisterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class RegistrationService {

    RegisterationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegisterationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getRegistrationByStdCode(long studentId){
        return registrationRepository.findByStudentId(studentId);
    }

    @Transactional
    public Registration saveRegistration(Registration registration){
        return registrationRepository.save(registration);
    }

    public List<Registration> findById(long id) {
        return registrationRepository.findByStudentId(id);
    }


//    @Transactional
//    public void deleteById(Long id) {
//        registrationRepository.deleteById(id);
//    }
}
