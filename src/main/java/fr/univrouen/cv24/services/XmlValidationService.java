package fr.univrouen.cv24.services;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

@Service
public class XmlValidationService {

    public boolean validateXml(String xmlData) throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try (InputStream xsdStream = getClass().getResourceAsStream("/cv24.tp1.xsd")) {
            if (xsdStream == null) {
                throw new Exception("XSD file not found in the resources.");
            }
            Schema schema = factory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            try {
                validator.validate(new StreamSource(new StringReader(xmlData)));
            } catch (SAXException e) {
                throw new Exception("Validation failed: " + e.getMessage(), e);
            }
            return true;
        } catch (IOException e) {
            throw new Exception("Error loading XSD file", e);
        }
    }

}
