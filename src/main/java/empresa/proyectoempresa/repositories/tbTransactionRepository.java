package empresa.proyectoempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tbTransactionRepository extends JpaRepository <tbTransactionRepository,Long>{
    
}
