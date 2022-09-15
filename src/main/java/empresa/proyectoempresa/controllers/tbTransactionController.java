package empresa.proyectoempresa.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import empresa.proyectoempresa.repositories.tbTransactionRepository;
import empresa.proyectoempresa.services.tbTransactionService;
import empresa.proyectoempresa.modelo.*;



@RestController
@RequestMapping("/")
public class tbTransactionController {

    @Autowired
    private tbTransactionRepository repositiorio;


    //Consultar un transaccion por ID---"PATCH"
    @RequestMapping(value = "/buscartransaccion/{idtran}", method = RequestMethod.GET)
    public tbTransaction buscartransaccion(@PathVariable long idtran) {
        return repositiorio.findById(idtran).get();
    }

     //Actulización parcial -- PATCH
     @RequestMapping(value = "/update/{idtran}", method =  RequestMethod.PATCH)
     public tbTransaction actualizar(@RequestBody tbTransaction tbtransaction){
     return repositiorio.save(tbtransaction);
     }
    //Agregar transaccion-----POST
    @RequestMapping (value = "/add",method = RequestMethod.POST)
     public tbTransaction create(@RequestBody tbTransaction tbtransaction){  
        return repositiorio.save(tbtransaction) ;
    }
    //Eliminar transaccion----delete
    @RequestMapping(value = "/delete/{ident}", method = RequestMethod.DELETE)
    public String eliminar(@PathVariable long idtran){
        tbTransaction tbtransaction=repositiorio.findById(idtran).get();
        repositiorio.delete(tbtransaction);
        return "Eliminada con exito";
    }


    

}
