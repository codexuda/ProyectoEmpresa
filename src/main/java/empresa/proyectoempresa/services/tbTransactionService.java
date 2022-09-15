package empresa.proyectoempresa.services;

import java.util.ArrayList;
import java.util.List;

import empresa.proyectoempresa.modelo.tbTransaction;
import empresa.proyectoempresa.repositories.tbTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//trabajandole

@Service
public class tbTransactionService {

   @Autowired
   private tbTransactionRepository TbTransactionRepository;

   public List<tbTransaction> getAllTransaction() {
      return (List<tbTransaction>) this.TbTransactionRepository.findAll();
      // List<tbTransaction> listarTransaccion = new ArrayList<>();
      // TbTransactionRepository.findAll().forEach(trasanccion ->
      // listarTransaccion.add(trasanccion));
      // return listarTransaccion;

   }
}
