package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.ClientDTO;
import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/cad")
    public ResponseEntity<String> cadClient(@RequestBody ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        clientRepository.save(client);
        return ResponseEntity.ok().body("Client Created");
    }


}
