package empresa.proyectoempresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.tbTransaction;

@Repository
public interface tbTransactionRepository extends JpaRepository <tbTransaction,Long>{
    List<tbTransaction> findByEnterpriseId(final Long enterpriseId);
    
}
