package com.jsca.jsca.prueba.service;

import com.jsca.jsca.prueba.model.Cliente;
import com.jsca.jsca.prueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente> getAllClientes(){return clienteRepository.findAll();}


    public Cliente createCliente(Cliente cliente){return clienteRepository.save(cliente);}

    public void  eliminarCliente(Long id){ clienteRepository.deleteById(id);}

    public Cliente findUserByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    public Cliente findUserByName(String name) {
        return clienteRepository.findByName(name);
    }

    public Optional<Cliente> getClienteByid(Long id){return clienteRepository.findById(id);}


    public String updateCliente(Cliente cliente) {
        Optional<Cliente> clienteExist = clienteRepository.findById(cliente.getId());

        if (clienteExist.isPresent()) {
            Cliente clienteUpdate = clienteExist.get();
            clienteUpdate.setName(cliente.getName());
            clienteUpdate.setEmail(cliente.getEmail());
            clienteUpdate.setTelefono(cliente.getTelefono());
            clienteRepository.save(clienteUpdate);
            return "Cliente actualizado";
        } else {
            return "Cliente no existe";
        }
    }



    public boolean clienteVerifi(Cliente cliente) {
        String name = cliente.getName();
        String grupo = cliente.getGrupo();
        Cliente clienteExistente = clienteRepository.findByNameAndGrupo(name, grupo);
        return clienteExistente == null;
    }

}
