package edu.uptc.swi.employeeapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.uptc.swi.employeeapp.model.Employee;
import edu.uptc.swi.employeeapp.service.EmployeeDAOImpl;
import edu.uptc.swi.employeeapp.service.IEmployeeDAO;

@Controller
public class AddEmployeeController {
    private IEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @PostMapping("/save")
    public RedirectView addEmployee(Employee employee) {
        boolean res = this.employeeDAO.save(employee);
        if (!res)
            return new RedirectView("error.html");
        else
            return new RedirectView("confirm.html");
    }

    @GetMapping("/search")
    public ModelAndView showSearchForm() {
        ModelAndView mv = new ModelAndView("searchEmployee");
        mv.addObject("employees", this.employeeDAO.findAll());
        return mv;
    }

    @PostMapping("/searchEmployee")
    public ModelAndView searchEmployee(@RequestParam("id") String id) {
        Employee employee = this.employeeDAO.findById(id);
        ModelAndView mv = new ModelAndView("searchResult");
        boolean found = employee != null && employee.getId() != null;
        mv.addObject("found", found);
        if (found) {
            mv.addObject("employee", employee);
        }
        return mv;
    }

    @GetMapping("/delete")
    public ModelAndView showDeleteForm() {
        ModelAndView mv = new ModelAndView("deleteEmployee");
        mv.addObject("employees", this.employeeDAO.findAll());
        return mv;
    }

    @PostMapping("/deleteEmployee")
    public RedirectView deleteEmployeeForm(@RequestParam("id") String id) {
        Employee employee = this.employeeDAO.findById(id);
        boolean exists = employee != null && employee.getId() != null;
        boolean res = exists && this.employeeDAO.deleteEmployeeById(id);
        if (!res)
            return new RedirectView("error.html");
        else
            return new RedirectView("confirm.html");
    }

    @GetMapping("/showAllEmployees")
    public ModelAndView showAllEmployees() {
        List<Employee> employees = this.employeeDAO.findAll();
        ModelAndView mv = new ModelAndView("employeeList");
        mv.addObject("employees", employees);
        return mv;
    }

    @RequestMapping("/findbyid")
    @ResponseBody
    public Employee findByID(String id) {
        return this.employeeDAO.findById(id);
    }

    @RequestMapping("/findall")
    @ResponseBody
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @RequestMapping("/deletebyid")
    @ResponseBody
    public void deleteEmployee(String id) {
        this.employeeDAO.deleteEmployeeById(id);
    }
}
