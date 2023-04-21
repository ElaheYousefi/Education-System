package ir.ac.qiau.iau.educational.service;

import ir.ac.qiau.iau.educational.model.Polling;
import ir.ac.qiau.iau.educational.repository.PollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PollingService {
    PollingRepository pollingRepository;

    @Autowired
    public PollingService(PollingRepository pollingRepository) {
        this.pollingRepository = pollingRepository;
    }

    @Transactional
    public Polling savePolling(Polling polling){
        return pollingRepository.save(polling);
    }

    public void getPollingInfo() {
    }
}
