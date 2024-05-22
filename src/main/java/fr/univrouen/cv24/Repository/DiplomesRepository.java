package fr.univrouen.cv24.Repository;

import fr.univrouen.cv24.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomesRepository extends JpaRepository<Diplome, Long> {
}