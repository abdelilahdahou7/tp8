package maa.enset.web;

import maa.enset.entities.Compte;
import maa.enset.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteRestController {
    private final CompteRepository compteRepository;

    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping
    public List<Compte> listComptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/{id}")
    public Compte updateCompte(@RequestBody Compte compte, @PathVariable Long id) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
