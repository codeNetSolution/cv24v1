package fr.univrouen.cv24.Repository;

import fr.univrouen.cv24.model.TestCV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<TestCV, Long> {
    boolean existsByIdentite_GenreAndIdentite_NomAndIdentite_PrenomAndIdentite_Telephone(String genre, String nom, String prenom, String telephone);
}
