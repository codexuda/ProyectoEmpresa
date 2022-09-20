package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import empresa.proyectoempresa.modelo.*;
import empresa.proyectoempresa.services.tbTransactionService;





@Controller
@RequestMapping("/")
public class FrontController {

    @Autowired
    tbTransactionService tbtransactionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //Controlador que conecta con la View
    //@RequestMapping(value = "/{enterprise}/movements", method = RequestMethod.GET)
    //public String ViewlistTransaccion(Model model) {
      // List<tbTransaction> ViewlistTransaccion = this.tbtransactionService.listarTransaccion();
        //model.addAttribute("ViewlistTransaccion", ViewlistTransaccion);
        //return "ListTransaccion";
    //}
}