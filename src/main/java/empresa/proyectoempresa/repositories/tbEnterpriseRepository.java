package empresa.proyectoempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.tbEnterprise;

@Repository
public interface tbEnterpriseRepository extends JpaRepository<tbEnterprise,Long> {

    
}
