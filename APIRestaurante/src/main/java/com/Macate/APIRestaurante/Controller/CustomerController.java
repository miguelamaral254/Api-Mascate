package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.CustomerDTO;
import com.Macate.APIRestaurante.Models.Customer;
import com.Macate.APIRestaurante.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    
    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> listCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping("/cad")
    public ResponseEntity<String> cadCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerRepository.save(customer);
        return ResponseEntity.ok().body("Customer Created");
    }
}
