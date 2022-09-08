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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<tbTransaction> listarTransaccion() {
        return repositiorio.findAll();

    }
    //Consultar un transaccion por ID---"
    @RequestMapping(value = "/get/{idTran}", method = RequestMethod.GET)
    public tbTransaction buscartransaccion(@PathVariable long idTran) {
        return repositiorio.findById(idTran).get();
    }

     //Actulización parcial -- PATCH
     @RequestMapping(value = "/update/{idTran}", method =  RequestMethod.PATCH)
     public tbTransaction actualizar(@RequestBody tbTransaction tbtransaction){
     return repositiorio.save(tbtransaction);
     }
    //Agregar transaccion-----POST
    @RequestMapping (value = "/add",method = RequestMethod.POST)
     public tbTransaction create(@RequestBody tbTransaction tbtransaction){  
        return repositiorio.save(tbtransaction) ;
    }
    //Eliminar transaccion----delete
    @DeleteMapping(value = "delete/{idTran}")
    public String eliminar(@PathVariable long idTran){
        repositiorio.delete(repositiorio.findById(idTran).get());
        return "Eliminada con exito";

   }    

}
