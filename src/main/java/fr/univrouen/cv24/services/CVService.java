package fr.univrouen.cv24.services;

import fr.univrouen.cv24.Repository.CVRepository;
import fr.univrouen.cv24.Repository.DiplomesRepository;
import fr.univrouen.cv24.Repository.ObjectifsRepository;
import fr.univrouen.cv24.dto.DiplomeDTO;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.ObjectifStatut;
import fr.univrouen.cv24.model.TestCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CVService {

    @Autowired
    private CVRepository testCVRepository;

    @Autowired
    private DiplomesRepository diplomesRepository;

    @Autowired
    private ObjectifsRepository objectifsRepository;


    @Transactional
    public boolean deleteCV(Long id) {
        if (testCVRepository.existsById(id)) {
            testCVRepository.deleteById(id);
            deleteDiplomes(id);
            return true;
        }
        return false;
    }

    public void deleteDiplomes(Long id){
        List<Diplome> diplomes = getAllDiplomesById(id);
        for(Diplome diplome : diplomes){
            Long idSupp = diplome.getId();
            diplomesRepository.deleteById(idSupp);
        }
    }

    public List<TestCV> getAllCVs() {
        return testCVRepository.findAll();
    }

    public List<TestCV> getTestCVById(Long id){
        assert testCVRepository.findById(id).isPresent();
        List<TestCV> listTestCv = new ArrayList<>();
        listTestCv.add(testCVRepository.findById(id).get());
        return listTestCv;
    }

    public List<Diplome> getAllDiplomesById(Long id) {
        List<Diplome> result = new ArrayList<>(List.of());
        if(diplomesRepository.existsById(id)){
            List<Diplome> filtre = diplomesRepository.findAll().stream().toList();
            for(Diplome diplome : filtre) {
                if(Objects.equals(diplome.getDiplomesId(), id)){
                    result.add(diplome);
                }
            }
        }
        return result;
    }

    public List<Diplome> getAllDiplomesByIdRecent(Long id) {
        List<Diplome> result = new ArrayList<>(List.of());
        List<Diplome> filter = getAllDiplomesById(id);

        if(filter.isEmpty()) {
            return result;
        }
        Diplome diplomeMaxNiveau = filter.get(0);
        for(Diplome diplome : filter){
            if(diplome.getNiveau() > diplomeMaxNiveau.getNiveau()) {
                diplomeMaxNiveau = diplome;
            }
        }
        result.add(diplomeMaxNiveau);

        return result;
    }

    public List<DiplomeDTO> getAllDiplomeHighLevel(List<DiplomeDTO> diplomeDTOS) {
        List<DiplomeDTO> result = new ArrayList<>(List.of());

        if(diplomeDTOS.isEmpty()) {
            return result;
        }
        DiplomeDTO diplomeMaxNiveau = diplomeDTOS.get(0);
        for(DiplomeDTO diplome : diplomeDTOS){
            if(diplome.getNiveau() > diplomeMaxNiveau.getNiveau()) {
                diplomeMaxNiveau = diplome;
            }
        }
        result.add(diplomeMaxNiveau);

        return result;
    }



    public ObjectifStatut getObjectifsStatutById(Long id){
        ObjectifStatut objectifStatut = null;
        if(objectifsRepository.existsById(id)){
            objectifStatut = objectifsRepository.getById(id);
        }
        return objectifStatut;
    }
}