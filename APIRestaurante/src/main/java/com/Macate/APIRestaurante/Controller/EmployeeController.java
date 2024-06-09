package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.EmployeeDTO;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Método para listar todos os funcionários
    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> listEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping("/cad")
    public ResponseEntity<String> cadEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body("Employee Created");
    }
}
