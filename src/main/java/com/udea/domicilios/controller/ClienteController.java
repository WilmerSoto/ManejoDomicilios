package com.udea.domicilios.controller;

import com.udea.domicilios.model.Cliente;
import com.udea.domicilios.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes", produces = {"application/vnd.domicilio.api.v1+json", "application/vnd.domicilio.api.v2+json"})
@CrossOrigin("*")
@Api(value = "Sistema de manejo de clientes", description = "Operaciones de clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Añadir Cliente")
    @PostMapping(value = "/save", produces = "application/json")
    public int save(
            @ApiParam(value = "Guardado de objeto Cliente en BD", required = true)
            @RequestBody Cliente cliente){
        clienteService.save(cliente);
        return cliente.getIdCliente();
    }

    @ApiOperation(value = "Lista de todos los clientes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista encontrada exitosamente")
    })
    @GetMapping(value = "/listAll", produces = "application/json")
    public Iterable<Cliente> listAllClientes() {
        return clienteService.list();
    }

    @ApiOperation(value = "Listar cliente")
    @GetMapping(value = "/list/{id}", produces = "application/vnd.domicilio.api.v1+json")
    public Cliente listClienteById(@ApiParam(value = "ID del cliente a retornar", required = true)
                                 @PathVariable("id") int id) {
        Optional<Cliente> cliente = clienteService.listId(id);
        return cliente.orElse(null);
    }

    @ApiOperation(value = "Listar cliente usando cedula")
    @GetMapping(value = "/list/{cedula}", produces = "application/vnd.domicilio.api.v2+json")
    public Cliente listClienteByCedula(@ApiParam(value = "Cedula del cliente a retornar", required = true)
                                     @PathVariable("cedula") String cedula) {
        Optional<Cliente> cliente = clienteService.listCedula(cedula);
        return cliente.orElse(null);
    }

    @ApiOperation(value = "Actualizar cliente")
    @PutMapping(value = "/update", produces = "application/json")
    public Cliente updateService(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }


    @ApiOperation(value = "Borrar cliente usando ID de la BD")
    @DeleteMapping(value = "deleteById/{id}", produces = "application/json")
    public String deleteCliente(@PathVariable int id) {
        return clienteService.delete(id);
    }

}
