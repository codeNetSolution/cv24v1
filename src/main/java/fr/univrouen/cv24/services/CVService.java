package fr.univrouen.cv24.services;

import fr.univrouen.cv24.Repository.CVRepository;
import fr.univrouen.cv24.model.TestCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CVService {

    @Autowired
    private CVRepository testCVRepository;

    @Transactional
    public boolean deleteCV(Long id) {
        if (testCVRepository.existsById(id)) {
            testCVRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TestCV> getAllCVs() {
        return testCVRepository.findAll();
    }
}