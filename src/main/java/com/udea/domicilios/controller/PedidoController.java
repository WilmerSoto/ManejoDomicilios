package com.udea.domicilios.controller;

import com.udea.domicilios.model.Pedido;
import com.udea.domicilios.service.PedidoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
@Api(value = "Sistema de manejo de pedidos", description = "Operaciones de pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @ApiOperation(value = "Añadir pedido")
    @PostMapping("/save")
    public long save(
            @ApiParam(value = "Guardado de objeto Pedido en BD", required = true)
            @RequestBody Pedido pedido) {
        pedidoService.save(pedido);
        return pedido.getIdPedido();
    }

    @ApiOperation(value = "Lista de todos los pedidos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista encontrada exitosamente")
    })
    @GetMapping("/listAll")
    public Iterable<Pedido> listAllPedidos() {
        return pedidoService.list();
    }

    @ApiOperation(value = "Get Driver by ID")
    @GetMapping("/listById/{id}")
    public Pedido listPedidoById(@ApiParam(value = "Listar pedido usando el ID de la BD", required = true)
                                 @PathVariable("id") int id) {
        Optional<Pedido> pedido = pedidoService.listId(id);
        return pedido.orElse(null);
    }

    @ApiOperation(value = "Actualizar pedido")
    @PutMapping("/update")
    public Pedido updateService(@RequestBody Pedido pedido) {
        return pedidoService.update(pedido);
    }

    @ApiOperation(value = "Borrar pedido usando ID")
    @DeleteMapping("deleteById/{id}")
    public String deletePedido(@PathVariable int id) {
        return pedidoService.delete(id);
    }

}
