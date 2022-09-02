package empresa.proyectoempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.tbEmployee;

@Repository 
public interface tbEmployeeRepository extends JpaRepository<tbEmployee, Long> {
    
}
