package com.jsca.jsca.prueba.controller;

import com.jsca.jsca.prueba.model.Cliente;
import com.jsca.jsca.prueba.repository.ClienteRepository;
import com.jsca.jsca.prueba.service.BeneficioService;
import com.jsca.jsca.prueba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BeneficioService beneficioService;

    @GetMapping(path = "/mostrar")
    public ResponseEntity<List<Cliente>> getClientes(){
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Cliente> getClientesForName(@PathVariable String nombre) {
        Cliente cliente = clienteService.findUserByName(nombre);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscar/{email}")
    public ResponseEntity<Cliente> getClientesForEmail(@PathVariable String email) {
        Cliente cliente = clienteService.findUserByEmail(email);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<String> createCliente(@RequestBody Map<String, String> requestMap) {
        String name = requestMap.get("nombre");
        String email = requestMap.get("email");
        String telefono = requestMap.get("telefono");
        String grupoSeleccionado = requestMap.get("grupo");

        // Verificar si el grupo seleccionado es válido "SK o TH"
        if (!grupoSeleccionado.equals("SK") && !grupoSeleccionado.equals("TH")) {
            return ResponseEntity.badRequest().body("El grupo seleccionado no es válido. Debe ser 'SK' o 'TH'.");
        }
        // Verificar si el grupo es "SK"  ya no tiene beneficios disponibles
        if (grupoSeleccionado.equals("TH")) {
            return ResponseEntity.badRequest().body("La lista SK ya no tiene beneficios disponibles.");
        }

        String beneficioAsignado = beneficioService.asignarBeneficio();
        Cliente cliente = new Cliente();
        cliente.setName(name);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setGrupo(grupoSeleccionado);

        // Realizar la validación del nombre único en el mismo grupo
        if (!clienteService.clienteVerifi(cliente)) {
            return ResponseEntity.badRequest().body("El nombre ya está en uso en este grupo");
        }

        clienteService.createCliente(cliente);
        return ResponseEntity.ok("Cliente registrado en el grupo " + grupoSeleccionado);
    }


    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente eliminado");
    }

    @PostMapping(path ="/actualizar")
    public String updateCliente( @RequestParam Long idCliente, @RequestParam String name, @RequestParam String email, @RequestParam String telefono, @RequestParam String grupo){
        // Verificar si el grupo seleccionado es válido "SK o TH"
        if (!grupo.equals("SK") && !grupo.equals("TH")) {
            return "El grupo seleccionado no es válido. Debe ser 'SK' o 'TH'.";
        }
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        cliente.setName(name);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setGrupo(grupo);
        if (!clienteService.clienteVerifi(cliente)) {
            return "El nombre ya está en uso en este grupo";
        }
        clienteService.updateCliente(cliente);

        return "Operación completada";
    }


}
