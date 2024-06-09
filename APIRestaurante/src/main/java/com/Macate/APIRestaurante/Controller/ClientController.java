package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.ClientDTO;
import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Método para listar todos os clientes
    @GetMapping("/getClient")
    public ResponseEntity<List<Client>> listClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok().body(clients);
    }

    @PostMapping("/cad")
    public ResponseEntity<String> cadClient(@RequestBody ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        clientRepository.save(client);
        return ResponseEntity.ok().body("Client Created");
    }
}
