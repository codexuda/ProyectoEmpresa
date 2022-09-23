package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import empresa.proyectoempresa.modelo.*;
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
        return "ListTransaccion";
    }

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
    }
    // fin bloque listar empleado

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

    @Autowired
    tbEnterpriseService enterpriseService;

    // Controlador Vista Empresa
    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public String ViewListEnterprises(Model model) {
        List<tbEnterprise> ViewListEnterprises = this.enterpriseService.listarEmpresas();
        model.addAttribute("ViewListEnterprises", ViewListEnterprises);
        return "ListEnterprise";

    }
}