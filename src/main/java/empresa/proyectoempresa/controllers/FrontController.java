package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//mport empresa.proyectoempresa.modelo.*;
import empresa.proyectoempresa.services.tbEmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.engine.AttributeName;

import antlr.collections.List;

@Controller
@RequestMapping("/")
public class FrontController {
    @Autowired
    tbEmployeeService tbEmployeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

     //metodo para listar en empleados en el front end
    @RequestMapping(value="/employee", method=RequestMethod.GET)
    public String employee (Model model) {
        List<Employee> employee = this.tbEmployeeService.getAllEmployee();
        model.addAttribute(AttributeName "employee", employee);
        return "Employee";
    }

}
