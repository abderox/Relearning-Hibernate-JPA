package com.adria.springbootth;

import com.adria.springbootth.entities.Contrat;
import com.adria.springbootth.repositories.ContratRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringBootThApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (ContratRepository contratRepository) {
        return args -> {
            contratRepository.save(new Contrat(null,"Contrat 2", 200.0, new Date(), "Client 2", false));
            contratRepository.save(new Contrat(null,"Contrat 3", 300.0, new Date(), "Client 3", false));
            contratRepository.save(new Contrat(null,"Contrat 4", 400.0, new Date(), "Client 4", false));
            contratRepository.save(new Contrat(null,"Contrat 5", 500.0, new Date(), "Client 5", false));
            contratRepository.save(new Contrat(null,"Contrat 6", 600.0, new Date(), "Client 6", false));
            contratRepository.save(new Contrat(null,"Contrat 7", 700.0, new Date(), "Client 7", false));
            contratRepository.save(new Contrat(null,"Contrat 8", 800.0, new Date(), "Client 8", false));
            contratRepository.save(new Contrat(null,"Contrat 1", 100.0, new Date(), "Client 1", false));
            contratRepository.save(new Contrat(null,"Contrat 9", 900.0, new Date(), "Client 9", false));
            contratRepository.save(new Contrat(null,"Contrat 10", 1000.0, new Date(), "Client 10", false));
            contratRepository.save(new Contrat(null,"Contrat 11", 1100.0, new Date(), "Client 11", false));
            contratRepository.save(new Contrat(null,"Contrat 12", 1200.0, new Date(), "Client 12", false));
            contratRepository.save(new Contrat(null,"Contrat 13", 1300.0, new Date(), "Client 13", false));
            contratRepository.save(new Contrat(null,"Contrat 14", 1400.0, new Date(), "Client 14", false));
            contratRepository.save(new Contrat(null,"Contrat 15", 1500.0, new Date(), "Client 15", false));
            contratRepository.save(new Contrat(null,"Contrat 16", 1600.0, new Date(), "Client 16", false));
            contratRepository.save(new Contrat(null,"Contrat 17", 1700.0, new Date(), "Client 17", false));
            contratRepository.save(new Contrat(null,"Contrat 18", 1800.0, new Date(), "Client 18", false));
            contratRepository.save(new Contrat(null,"Contrat 19", 1900.0, new Date(), "Client 19", false));
            contratRepository.save(new Contrat(null,"Contrat 20", 2000.0, new Date(), "Client 20", false));
            contratRepository.save(new Contrat(null,"Contrat 21", 2100.0, new Date(), "Client 21", false));
            contratRepository.save(new Contrat(null,"Contrat 22", 2200.0, new Date(), "Client 22", false));
            contratRepository.save(new Contrat(null,"Contrat 23", 2300.0, new Date(), "Client 23", false));
            contratRepository.save(new Contrat(null,"Contrat 24", 2400.0, new Date(), "Client 24", false));
            contratRepository.save(new Contrat(null,"Contrat 25", 2500.0, new Date(), "Client 25", false));



            contratRepository.findAll().forEach(System.out::println);
        };
    }
}
