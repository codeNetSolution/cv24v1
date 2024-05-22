package fr.univrouen.cv24.util;

public class GenerateError {

    private String generateErrorXml(Long id, String status) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<error>" +
                "<id>" + id + "</id>" +
                "<status>" + status + "</status>" +
                "</error>";
    }
}
