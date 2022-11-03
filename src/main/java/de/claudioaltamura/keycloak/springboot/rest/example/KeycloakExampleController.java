package de.claudioaltamura.keycloak.springboot.rest.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@CrossOrigin(maxAge = 3600)
public class KeycloakExampleController {

    @GetMapping("/anonymous")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("anonymous");
    }

    @RolesAllowed("user")
    @GetMapping("/user")
    public ResponseEntity<String> user() {

        return ResponseEntity.ok("[\n" +
                "{\n" +
                "\"userId\": 1,\n" +
                "\"name\": \"Özgür\",\n" +
                "\"surname\": \"OKKA\",\n" +
                "\"company\": \"Aselsan\"\n" +
                "},\n" +
                "{\n" +
                "\"userId\": 2,\n" +
                "\"name\": \"Hakan\",\n" +
                "\"surname\": \"KOÇAK\",\n" +
                "\"company\": \"CyberSoft\"\n" +
                "},\n" +
                "{\n" +
                "\"userId\": 3,\n" +
                "\"name\": \"Hakan\",\n" +
                "\"surname\": \"Durmaz\",\n" +
                "\"company\": \"HAVELSAN\"\n" +
                "}\n" +
                "]");
    }

    @RolesAllowed("admin")
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("admin");
    }

}
