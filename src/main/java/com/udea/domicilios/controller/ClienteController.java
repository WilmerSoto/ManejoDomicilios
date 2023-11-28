package com.udea.domicilios.controller;

import com.udea.domicilios.model.Cliente;
import com.udea.domicilios.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
@Api(value = "Sistema de manejo de clientes", description = "Operaciones de clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Añadir Cliente")
    @PostMapping("/save")
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
    @GetMapping("/listAll")
    public Iterable<Cliente> listAllClientes() {
        return clienteService.list();
    }

    @ApiOperation(value = "Listar cliente usando el ID de la BD")
    @GetMapping(value = "/list/{id}", headers = "API-VERSION=1")
    public Cliente listClienteById(@ApiParam(value = "ID del cliente a retornar", required = true)
                                 @PathVariable("id") int id) {
        Optional<Cliente> cliente = clienteService.listId(id);
        return cliente.orElse(null);
    }

    @ApiOperation(value = "Listar cliente usando cedula ")
    @GetMapping(value = "/list/{cedula}", headers = "API-VERSION=2")
    public Cliente listClienteByCedula(@ApiParam(value = "Cedula del cliente a retornar", required = true)
                                     @PathVariable("cedula") String cedula) {
        Optional<Cliente> cliente = clienteService.listCedula(cedula);
        return cliente.orElse(null);
    }

    @ApiOperation(value = "Actualizar cliente")
    @PutMapping("/update")
    public Cliente updateService(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }


    @ApiOperation(value = "Borrar cliente usando ID de la BD")
    @DeleteMapping("deleteById/{id}")
    public String deleteCliente(@PathVariable int id) {
        return clienteService.delete(id);
    }

    @ApiOperation(value = "Borrar cliente usando cedula")
    @DeleteMapping("deleteByCedula/{cedula}")
    public String deleteClienteCedula(@PathVariable String cedula) {
        return clienteService.deleteCedula(cedula);
    }
}
