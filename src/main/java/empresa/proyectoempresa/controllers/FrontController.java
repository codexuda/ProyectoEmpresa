package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import empresa.proyectoempresa.modelo.*;
//import empresa.proyectoempresa.modelo.tbTransaction;
import empresa.proyectoempresa.services.tbTransactionService;
import empresa.proyectoempresa.services.tbEmployeeService;


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

    //Bloque para listar empleado
    //@Controller
    @RequestMapping("/")
    public class FrontController {
        @Autowired
        tbEmployeeService tbEmployeeService;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index() {
            return "index";
        }

        // metodo para listar empleados en el front end
        @RequestMapping(value = "/employee", method = RequestMethod.GET)
        public String employee(Model model) {
            List<tbEmployee> employee = this.tbEmployeeService.getAllEmployees();
            model.addAttribute("employee", employee);
            return "Employee";
        }

    }
    //fin bloque listar empleado

}