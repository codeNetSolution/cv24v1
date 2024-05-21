package fr.univrouen.cv24.controllers;


import fr.univrouen.cv24.services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteController {

    @Autowired
    private CVService cvService;

    @DeleteMapping("/cv24/delete")
    public ResponseEntity<String> deleteCV(@RequestParam Long id) {
        boolean isDeleted = cvService.deleteCV(id);
        if (isDeleted) {
            return ResponseEntity.ok("<response><id>" + id + "</id><status>DELETED</status></response>");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("<response><status>ERROR</status></response>");
        }
    }
}
