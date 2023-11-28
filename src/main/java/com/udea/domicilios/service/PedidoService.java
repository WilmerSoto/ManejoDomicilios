package com.udea.domicilios.service;

import com.udea.domicilios.dao.IPedidoDAO;
import com.udea.domicilios.model.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PedidoService {
    @Autowired
    private IPedidoDAO dao;

    public void save(Pedido t) {
        dao.save(t);
    }

    @Transactional
    public String delete(int id) {
        dao.deleteById(id);
        return "Pedido con ID "+ id + "eliminado";
    }

    public Iterable<Pedido> list() {
        return dao.findAll();
    }

    public Optional<Pedido> listId(int id) {
        return dao.findById(id);
    }

    public Pedido update(Pedido d) {
        Pedido existingPedido = dao.findById(d.getIdPedido()).orElse(null);
        existingPedido.setNombreItem(d.getNombreItem());
        existingPedido.setDireccionEntrega(d.getDireccionEntrega());
        existingPedido.setValorTotal(d.getValorTotal());
        existingPedido.setCliente(d.getCliente());
        return dao.save(existingPedido);
    }
}

