package cn.quguai.restfulcrud.controller;

import cn.quguai.restfulcrud.dao.DepartmentDao;
import cn.quguai.restfulcrud.dao.EmployeeDao;
import cn.quguai.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@Controller
@RequestMapping("/admin")
public class EmployeeController {

    @Autowired
    EmployeeDao dao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = dao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String addEmpPage(Model model) {
        model.addAttribute("departments", departmentDao.getDepartments());
        return "emp/add";
    }

    @PostMapping("/emp")
    public String saveEmp(Employee employee, RedirectAttributes attributes) {
        dao.save(employee);
        attributes.addFlashAttribute("message", "新增成功");
        return "redirect:/admin/emps";
    }

    @GetMapping("/emp/{id}")
    public String getEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = dao.get(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentDao.getDepartments());
        return "emp/add";
    }

    @PutMapping("/emp/")
    public String update(Employee employee, RedirectAttributes attributes) {
        dao.save(employee);
        attributes.addFlashAttribute("message", "Success");
        return "redirect:/admin/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        dao.delete(id);
        return "redirect:/admin/emps";
    }

}
