package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import empresa.proyectoempresa.modelo.tbTransaction;
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
    @RequestMapping(value = "/movimientos", method = RequestMethod.GET)
    public String ViewlistTransaccion(Model model) {
       List<tbTransaction> ViewlistTransaccion = this.tbtransactionService.listarTransaccion();
        model.addAttribute("ViewlistTransaccion", ViewlistTransaccion);
        return "ListTransaccion";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute tbTransaction tbtransaction, Model model){
        System.out.println(tbtransaction);
        model.addAttribute("tbtransaction", new tbTransaction());
        return "AgregarTransaccion";
    }


        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public String addTransaction(@ModelAttribute tbTransaction tbtransaction, Model model){
            System.out.println(tbtransaction);
            this.tbtransactionService.createTransaction(tbtransaction);
            return "redirect:/movimientos";
    }
}