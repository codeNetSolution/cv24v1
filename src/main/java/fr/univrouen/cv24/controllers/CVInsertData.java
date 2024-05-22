package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.Repository.CVRepository;
import fr.univrouen.cv24.Repository.DiplomesRepository;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.services.XmlValidationService;
import jakarta.xml.bind.helpers.DefaultValidationEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import jakarta.xml.bind.*;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
@RequestMapping("/cv24/insert")
public class CVInsertData {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private DiplomesRepository diplomesRespository;

    @Autowired
    private XmlValidationService xmlValidationService;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> insertCV(@RequestBody String xmlData) {
        try {
            System.out.println("XML Received: " + xmlData); // Log the raw XML data

            if (!xmlValidationService.validateXml(xmlData)) {
                return ResponseEntity.badRequest().body(createResponse(null, "ERROR", "INVALIDXML", null));
            }

            JAXBContext context = JAXBContext.newInstance(TestCV.class, Identite.class, Profession.class, Competence.class, Diplome.class, Certification.class, Langue.class, Autre.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            unmarshaller.setEventHandler(new DefaultValidationEventHandler());
            StringReader reader = new StringReader(xmlData);
            TestCV cv = (TestCV) unmarshaller.unmarshal(reader);

            Identite identite = cv.getIdentite();
            if (cvRepository.existsByIdentite_GenreAndIdentite_NomAndIdentite_PrenomAndIdentite_Telephone(identite.getGenre(), identite.getNom(), identite.getPrenom(), identite.getTelephone())) {
                return ResponseEntity.ok(createResponse(cv.getId(), "ERROR", "DUPLICATED", cv));
            }
            cv = cvRepository.save(cv);
            List<Diplome> listTest = diplomesRespository.findAll();
            for(Diplome dip : listTest) {
                if(dip.getDiplomesId() == null) {
                    dip.setDiplomesId(cv.getId());
                    diplomesRespository.save(dip);
                    cvRepository.save(cv);
                }
            }
            return ResponseEntity.ok(createResponse(cv.getId(), "INSERTED", null, cv));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(createResponse(null, "ERROR", e.getMessage(), null));
        }
    }



    private String createResponse(Long id, String status, String detail, TestCV cv) {
        return "<response><id>" + id + "</id><status>" + status + "</status><detail>" + detail + "</detail></response>" + cv;
    }
}
