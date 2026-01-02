package maa.enset;

import maa.enset.entities.Compte;
import maa.enset.enums.TypeCompte;
import maa.enset.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, 9000, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 6000, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 2500, new Date(), TypeCompte.COURANT));

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.getType() + ":" + c.getSolde());
            });
        };
    }
}
