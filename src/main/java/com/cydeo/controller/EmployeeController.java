package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee",new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";
    }

    @PostMapping("/insert")   // bindingResult parameter must be passed right after the object you want to validate
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }

        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";  //with re-direct we use endpoints
    }

    @GetMapping("/list")
     public String listEmployee(Model model){
        model.addAttribute("employeeList",employeeService.readAllEmployees());
        return "employee/employee-list"; //without re-direct we use html file paths
     }
}
