package empresa.proyectoempresa.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import empresa.proyectoempresa.repositories.tbTransactionRepository;
import empresa.proyectoempresa.modelo.*;

@RestController
@RequestMapping("/transactions")
public class tbTransactionController {

    @Autowired
    private tbTransactionRepository repositiorio;

    //Listar todas las transacciones----GET
    @RequestMapping(value = "/listartransacciones", method = RequestMethod.GET)
    public List<tbTransaction> listarTransaccion() {
        return repositiorio.findAll();

    }
    //Consultar un transaccion por ID---"PATCH"
    @RequestMapping(value = "/buscartransaccion/{idTran}", method = RequestMethod.GET)
    public tbTransaction buscartransaccion(@PathVariable long idTran) {
        return repositiorio.findById(idTran).get();
    }

    //Agregar transaccion-----POST
    @RequestMapping (value = "/add",method = RequestMethod.POST)
     public tbTransaction create(tbTransaction tbtransaction){  
        return repositiorio.save(tbtransaction) ;
    }
    //Eliminar----delete
    @RequestMapping(value = "/delete/{ident}", method = RequestMethod.DELETE)
    public String eliminar(@PathVariable long idTran){
        tbTransaction tbtransaction=repositiorio.findById(idTran).get();
        repositiorio.delete(tbtransaction);
        return "Eliminada con exito";
    }


    

}
