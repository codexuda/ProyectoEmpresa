package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import empresa.proyectoempresa.modelo.*;
import empresa.proyectoempresa.services.tbEmployeeService;
import org.thymeleaf.engine.AttributeName;
import java.util.*;
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

    // metodo para listar en empleados en el front end
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee(Model model) {
        List<tbEmployee> employee = this.tbEmployeeService.getAllEmployees();
        model.addAttribute("employee", employee);
        return "Employee";
    }

}
