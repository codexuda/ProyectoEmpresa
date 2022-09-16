package empresa.proyectoempresa.controllers;

import empresa.proyectoempresa.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;


import empresa.proyectoempresa.services.tbEmployeeService;

@Controller
@RequestMapping("/Employee")
    public class FrontController{
        @Autowired
        private tbEmployeeService employeeService;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index(){
            return "index";
        }
    }


