package empresa.proyectoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import empresa.proyectoempresa.services.tbEmployeeService;

@Controller
@RequestMapping("/Employee")
    public class FrontController{
        @Autowired
        private tbEmployeeService tbEmployeeService;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index(){
            return "index";
        }
    }


