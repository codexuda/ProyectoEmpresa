package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> f221577c7b116c1aaf5de7bcf437ac7516c729da
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import empresa.proyectoempresa.modelo.*;
import empresa.proyectoempresa.modelo.tbTransaction;
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import empresa.proyectoempresa.modelo.*;
>>>>>>> 69a03643977512ca546314d40b7208b7c057d53e
import empresa.proyectoempresa.services.*;
import empresa.proyectoempresa.controllers.tbEmployeeController;

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
        return "ListTransactions";
    }

<<<<<<< HEAD
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute tbTransaction tbtransaction, Model model){
        System.out.println(tbtransaction);
        model.addAttribute("tbtransaction", new tbTransaction());
        return "AddTransactions";
=======
    // Bloque para listar empleado
    @Autowired
    tbEmployeeService tbEmployeeService;

    // metodo para listar empleados en el front end, llamando el metodo desde el
    // controlador
    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public String listEmployee(Model model) {
        List<tbEmployee> listEmployee = this.tbEmployeeService.getAllEmployees();
        model.addAttribute("listEmployee", listEmployee);
        return "ListEmployee";
>>>>>>> 69a03643977512ca546314d40b7208b7c057d53e
    }
    // fin bloque listar empleado

<<<<<<< HEAD
    //Bloque para agregar empleado
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute tbEmployee employee, Model model){
        model.addAttribute("employee", new tbEmployee());
        return "AddEmployee";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute tbEmployee employee, Model model){
        this.tbEmployeeController.agregar(employee);
        return "redirect:/empleados";
    }
    //fin bloque agregar empleado//

    //fin bloque agregar empleado

=======
<<<<<<< HEAD

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public String addTransaction(@ModelAttribute tbTransaction tbtransaction, Model model){
            System.out.println(tbtransaction);
            this.tbtransactionService.createTransaction(tbtransaction);
            return "redirect:/movimientos";

        }
        
    //Bloque para listar empleado
    //@Controller
    //@RequestMapping("/")
    //public class FrontController {
    //    @Autowired
       // tbEmployeeService tbEmployeeService;
        //@RequestMapping(value = "/", method = RequestMethod.GET)
        //public String index() {
            //return "index";
        //}
        // metodo para listar empleados en el front end, llamando el metodo desde el controlador
      //  @RequestMapping(value = "/employee", method = RequestMethod.GET)
       // public String listEmployee(Model model) {
         //   List<tbEmployee> listEmployee = this.tbEmployeeService.getAllEmployees();
           // model.addAttribute("listEmployee", listEmployee);
            //return "Employee";
       // }

    //fin bloque listar empleado
=======
>>>>>>> 69a03643977512ca546314d40b7208b7c057d53e
>>>>>>> f221577c7b116c1aaf5de7bcf437ac7516c729da
    @Autowired
    tbEnterpriseService enterpriseService;

    // Controlador Vista Empresa
    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public String ViewListEnterprises(Model model) {
        List<tbEnterprise> ViewListEnterprises = this.enterpriseService.listarEmpresas();
        model.addAttribute("ViewListEnterprises", ViewListEnterprises);
        return "ListEnterprise";
<<<<<<< HEAD
        
=======

>>>>>>> 69a03643977512ca546314d40b7208b7c057d53e
    }
}