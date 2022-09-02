package empresa.proyectoempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.tbenumrolename;

@Repository 
public interface tbenumrolenameRepository extends JpaRepository<tbenumrolename, Long> {
    
}