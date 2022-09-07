package empresa.proyectoempresa.services;

import java.util.ArrayList;

import empresa.proyectoempresa.modelo.tbTransaction;
import empresa.proyectoempresa.repositories.tbTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//trabajandole

@Service
public class tbTransactionService {

   @Autowired 
   tbTransactionRepository TbTransactionRepository;

   public ArrayList<tbTransaction> listarTransaccion(){
        return (ArrayList<tbTransaction>) TbTransactionRepository.findAll();

   }
}
