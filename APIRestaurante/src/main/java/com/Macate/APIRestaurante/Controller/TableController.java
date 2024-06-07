package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.CheckoutDTO;
import com.Macate.APIRestaurante.DTOs.TableDTO;
import com.Macate.APIRestaurante.Models.Tablee;
import com.Macate.APIRestaurante.repository.TableRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @PutMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody CheckoutDTO checkoutDTO) {
        try {
            Tablee table = tableRepository.findBytableID(checkoutDTO.tableID())
                    .orElseThrow(() -> new RuntimeException("Table not found with ID: " + checkoutDTO.tableID()));
            table.setAvailability(true);
            tableRepository.save(table);
            return ResponseEntity.ok().body("Table with ID: " + checkoutDTO.tableID() + " is now available.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during checkout.");
        }
    }

    @PostMapping("/cad")
    public ResponseEntity<String> cadTable(@RequestBody TableDTO tableDTO){
        Tablee tablee =  new Tablee();
        BeanUtils.copyProperties(tableDTO, tablee);
        tableRepository.save(tablee);
        return ResponseEntity.ok().body("Table Created");
    }

    @GetMapping("/getTable")
    public ResponseEntity<List<Tablee>> gatTable(){
        List<Tablee> Tables = tableRepository.findAll();
        return ResponseEntity.ok().body(Tables);
    }

}
