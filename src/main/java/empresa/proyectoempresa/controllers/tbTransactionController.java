package empresa.proyectoempresa.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import empresa.proyectoempresa.repositories.tbTransactionRepository;
import  empresa.proyectoempresa.modelo.*;

@RestController
@RequestMapping ("/transaction")
public class tbTransactionController {

    @Autowired
    private tbTransactionRepository repositiorio;

public List<tbTransaction> listarTransaccion (){
    return repositiorio.findAll();
    
}

}
