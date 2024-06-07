package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.EmployeeDTO;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/cad")
    public ResponseEntity<String> cadEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body("Employee Creatad");
    }

}
