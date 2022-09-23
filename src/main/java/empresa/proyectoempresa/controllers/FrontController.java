package empresa.proyectoempresa.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import empresa.proyectoempresa.modelo.*;
//import empresa.proyectoempresa.modelo.tbTransaction;
import empresa.proyectoempresa.services.tbTransactionService;
//import empresa.proyectoempresa.services.tbEmployeeService;
import empresa.proyectoempresa.services.tbEnterpriseService;


@Controller
@RequestMapping("/")
public class FrontController {

    @Autowired
    tbTransactionService tbtransactionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    // Controlador que conecta con la View
    @RequestMapping(value = "/movimientos", method = RequestMethod.GET)
    public String ViewlistTransaccion(Model model) {
        List<tbTransaction> ViewlistTransaccion = this.tbtransactionService.listarTransaccion();
        model.addAttribute("ViewlistTransaccion", ViewlistTransaccion);
        return "ListTransaccion";
    }
<<<<<<< HEAD

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
=======
/* 
    //Bloque para listar empleado
    //@Controller
    @RequestMapping("/")
    public class FrontController {
        @Autowired
        private tbEmployeeService tbEmployeeService;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index() {
            return "index";
        }

        // metodo para listar empleados en el front end, llamando el metodo desde el controlador
        @RequestMapping(value = "/employee", method = RequestMethod.GET)
        public String employee(Model model) {
            List<tbEmployee> employee = this.tbEmployeeController.listar();
            model.addAttribute("employee", employee);
            return "Employee";
        }

    }
    //fin bloque listar empleado
*/
    @Autowired
    tbEnterpriseService enterpriseService;
    //Controlador Vista Empresa
    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public String ViewListEnterprises(Model model){
        List<tbEnterprise> ViewListEnterprises= this.enterpriseService.listarEmpresas();
        model.addAttribute("ViewListEnterprises", ViewListEnterprises);
        return "ListEnterprise";
        
>>>>>>> 0fe94f61f35c575821d06e04fe5876b4027ed031
    }
}