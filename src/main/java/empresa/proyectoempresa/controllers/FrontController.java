package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import empresa.proyectoempresa.modelo.*;
import empresa.proyectoempresa.services.*;

@Controller
public class FrontController {

    // Index
      @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }


    // Controlador View Transacciones

    @Autowired
    tbTransactionService tbtransactionService;

    @RequestMapping(value = "/movimientos", method = RequestMethod.GET)
    public String ViewlistTransaccion(Model model) {
        List<tbTransaction> ViewlistTransaccion = this.tbtransactionService.listarTransaccion();
        model.addAttribute("ViewlistTransaccion", ViewlistTransaccion);
        return "ListTransactions";
    }
    // Controller para agregar transacción.
    @RequestMapping(value = "/movimientos/add", method = RequestMethod.GET)
    public String add(@ModelAttribute tbTransaction tbtransaction, @ModelAttribute tbEmployee tbemployee,
    @ModelAttribute tbEnterprise enterprise, Model model) {
        System.out.println(tbtransaction);
        
        
        model.addAttribute("listaEmpleados", employeeService.getAllEmployees());
        model.addAttribute("listaEmpresas", enterpriseService.listarEmpresas());
        model.addAttribute("tbtransaction", new tbTransaction());
        return "AddTransactions";
    }

    @RequestMapping(value = "/movimientos/add", method = RequestMethod.POST)
    public String addTransaction(@ModelAttribute tbTransaction tbtransaction, Model model) {
        System.out.println(tbtransaction);


        this.tbtransactionService.createTransaction(tbtransaction);
        return "redirect:/movimientos";

    }

    // Bloque para listar empleado

    @Autowired
    tbEmployeeService employeeService;

    // metodo para listar empleados en el front end, llamando el metodo desde el
    // controlador
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String listEmployee(Model model) {
        List<tbEmployee> listEmployee = this.employeeService.getAllEmployees();
        model.addAttribute("listEmployee", listEmployee);
        return "ListEmployee";
    }
    // fin bloque listar empleado

    // Bloque para agregar empleado

    @RequestMapping(value = "/usuarios/add", method = RequestMethod.GET)
    public String add(@ModelAttribute tbEmployee tbemployee, @ModelAttribute tbEnterprise enterprise, Model model) {
        System.out.println(tbemployee);
        model.addAttribute("listaEmpresas", enterpriseService.listarEmpresas());
        model.addAttribute("tbemployee", new tbEmployee());
        return "AddEmployee";
    }

    @RequestMapping(value = "/usuarios/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute tbEmployee employee, Model model) {
        this.employeeService.agregarUsuario(employee);
        return "redirect:/empleados";
    }
    // fin bloque agregar empleado//

    // Controlador Vista Empresa
    @Autowired
    tbEnterpriseService enterpriseService;

    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public String ViewListEnterprises(Model model) {
        List<tbEnterprise> ViewListEnterprises = this.enterpriseService.listarEmpresas();
        model.addAttribute("ViewListEnterprises", ViewListEnterprises);
        return "ListEnterprise";

    }

    @RequestMapping(value = "/empresas/add", method = RequestMethod.GET)
    public String add(@ModelAttribute tbEnterprise tbEnterprise, Model model) {
        System.out.println(tbEnterprise);
        model.addAttribute("tbEnterprise", new tbEnterprise());
        return "AddEnterprise";
    }

    @RequestMapping(value = "/empresas/add", method = RequestMethod.POST)
    public String addEnterprise(@ModelAttribute tbEnterprise tbEnterprise, Model model) {
        System.out.println(tbEnterprise);
        this.enterpriseService.agregarEmpresa(tbEnterprise);
        return "redirect:/empresas";

    }
}