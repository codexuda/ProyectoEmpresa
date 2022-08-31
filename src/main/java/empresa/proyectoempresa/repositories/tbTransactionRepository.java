package empresa.proyectoempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.tbTransaction;

@Repository
public interface tbTransactionRepository extends JpaRepository <tbTransaction,Long>{
    
}
