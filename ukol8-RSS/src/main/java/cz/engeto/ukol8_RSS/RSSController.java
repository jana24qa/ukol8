package cz.engeto.ukol8_RSS;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class RSSController {

    private String readFile(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource(fileName);
        Path path = resource.getFile().toPath();
        return Files.readString(path);
    }

    @GetMapping("/api/scifi")
    public String scifi() throws IOException {
        return readFile("scifi.txt");
    }

    @GetMapping("/api/romatic")
    public String romatic() throws IOException {
        return readFile("romatic.txt");
    }

    @GetMapping("/api/historic")
    public String historic() throws IOException {
        return readFile("historic.txt");
    }
}
