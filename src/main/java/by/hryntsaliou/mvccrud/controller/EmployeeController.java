package by.hryntsaliou.mvccrud.controller;

import by.hryntsaliou.mvccrud.entity.Employee;
import by.hryntsaliou.mvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {

        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
