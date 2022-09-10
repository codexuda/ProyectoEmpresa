package empresa.proyectoempresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.proyectoempresa.modelo.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction,Long>{
    List<Transaction> findByEnterpriseId(final Long enterpriseId);
    
}
