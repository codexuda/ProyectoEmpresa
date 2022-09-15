package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.*;
import empresa.proyectoempresa.services.tbTransactionService;



import java.util.List;

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
    @RequestMapping(value = "/ListTransaccion", method = RequestMethod.GET)
    public String ViewlistTransaccion(Model model) {
        List<tbTransaction> ViewlistTransaccion = this.tbtransactionService.getAllTransaction();
        model.addAttribute("ViewlistTransaccion", ViewlistTransaccion);
        return "index";

    }
}