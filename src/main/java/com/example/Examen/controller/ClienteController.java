package com.example.Examen.controller;


import com.example.Examen.entity.Cliente;
import com.example.Examen.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<Cliente> getClientes() {
        return clienteRepository.getListaClientes();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Cliente> getClientes(@PathVariable String name) {
        Optional<Cliente> optionalCliente = clienteRepository.buscarCliente(name);
        if(optionalCliente.isEmpty()){
            System.out.println("");
        }
        return ResponseEntity.ok(optionalCliente.get());
    }
    @PostMapping
    public void crearCliente(@RequestBody Cliente cliente){
        Cliente clientes = modelMapper.map(cliente, Cliente.class);
        clienteRepository.getListaClientes().add(cliente);
    }
    @DeleteMapping("/{cliente}")
    public void eliminarCliente(@PathVariable("cliente") String cliente) throws ClienteInexistenteException{
        //Optional<Cliente> optionalCliente = clienteRepository.buscarCliente(cliente);
        //optionalCliente.ifPresent(value -> clienteRepository.getListaCliente().remove(value));
        Optional<Cliente> optionalCliente = clienteRepository.buscarCliente(cliente);
        if(optionalCliente.isPresent()){
            optionalCliente.ifPresent(value -> clienteRepository.getListaClientes().remove(value));
        }
        throw new ClienteInexistenteException();
    }
    @PutMapping("/actualizarCliente")
    public void actualizarCliente(@RequestBody Cliente cliente) throws ClienteInexistenteException {
        Optional<Cliente> optionalCliente = clienteRepository.buscarCliente(cliente.getNombre());
        if (optionalCliente.isPresent()) {
            for (Cliente c : clienteRepository.getListaClientes()) {
                if (c.getNombre().equals(cliente.getNombre())) {
                    c.setDni(cliente.getDni());
                    c.setNombre(cliente.getNombre());
                    c.setDomicilio(cliente.getDomicilio());
                }
            }
        } else {
            throw new ClienteInexistenteException();
        }
    }
}
