package fr.univrouen.cv24.Repository;

import fr.univrouen.cv24.model.ObjectifStatut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectifsRepository extends JpaRepository<ObjectifStatut, Long> {
}
