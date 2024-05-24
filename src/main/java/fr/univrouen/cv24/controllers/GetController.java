package fr.univrouen.cv24.controllers;


import fr.univrouen.cv24.dto.CvListDTO;
import fr.univrouen.cv24.dto.TestCVDTO;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import fr.univrouen.cv24.Repository.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
public class GetController {
	
	@Autowired
    private CVRepository cvRepository;

	@Autowired
	private CVService cvService;


	@GetMapping(value = "/cv24/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CvListDTO> showCVsXML() {
		List<TestCV> cvs = cvService.getAllCVs();
		List<TestCVDTO> cvDTOs = cvs.stream()
				.map(TestCVDTO::new)
				.collect(Collectors.toList());
		CvListDTO cvListDTO = new CvListDTO(cvDTOs);
		return ResponseEntity.ok(cvListDTO);
	}

	@GetMapping(value = "/cv24/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> cvXMLId(@RequestParam Long id) {
		List<TestCV> cvs;
		try {
			cvs = cvService.getTestCVById(id);
		} catch (NoSuchElementException e) {
			ErrorResponse errorResponse = new ErrorResponse(id, "Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
		List<TestCVDTO> cvDTOs = cvs.stream()
				.map(TestCVDTO::new)
				.collect(Collectors.toList());
		CvListDTO cvListDTO = new CvListDTO(cvDTOs);
		return ResponseEntity.ok(cvListDTO);
	}


}