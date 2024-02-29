package com.rftg.toad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ToadApplication {
    public static void main(String[] args) {
      SpringApplication.run(ToadApplication.class, args);
    }
    
}