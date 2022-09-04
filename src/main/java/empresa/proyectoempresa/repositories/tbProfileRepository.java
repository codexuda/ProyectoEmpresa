package empresa.proyectoempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.tbProfile;

@Repository
public interface tbProfileRepository extends JpaRepository <tbProfile,Long>{
    
}
