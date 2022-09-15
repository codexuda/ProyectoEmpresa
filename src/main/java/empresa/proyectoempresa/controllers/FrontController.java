package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbTransaction;
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

    // Listar todas las transacciones----GET
    // @RequestMapping({"/","/list"})
    // @RequestMapping(value = "/list", method = RequestMethod.GET)
    // public String viwTrasanccioneString(Model modelo, @ModelAttribute("mensaje")
    // String Mensaje) {
    // List<tbTransaction> listTrasanccion =
    // tbtransactionService.getAllTransaction();
    // modelo.addAttribute("listarTransaccion",listTrasanccion);
    // modelo.addAttribute("Mensaje", Mensaje);
    // return "index";

    // }

    @RequestMapping(value = "/listTrasanccion", method = RequestMethod.GET)
    public String listTrasanccion(Model model) {
        List<tbTransaction> listTrasanccion = this.tbtransactionService.getAllTransaction();
        model.addAttribute("listTrasanccion", listTrasanccion);
        return "index";

    }
}