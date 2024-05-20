package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.Repository.CVRepository;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Optional;

@RestController
@RequestMapping("/cv24/xml")
public class CVController {

    @Autowired
    private CVRepository cvRepository;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getCVById(@RequestParam(value = "id") Long id) {
        Optional<TestCV> cv = cvRepository.findById(id);
        if (cv.isPresent()) {
            try {
                JAXBContext context = JAXBContext.newInstance(TestCV.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                StringWriter writer = new StringWriter();
                marshaller.marshal(cv.get(), writer);

                return ResponseEntity.ok(writer.toString());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(generateErrorXml(id, "Unable to marshal CV"));
            }
        } else {
            return ResponseEntity.ok(generateErrorXml(id, "ERROR"));
        }
    }

    private String generateErrorXml(Long id, String status) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<error>" +
                "<id>" + id + "</id>" +
                "<status>" + status + "</status>" +
                "</error>";
    }
}
