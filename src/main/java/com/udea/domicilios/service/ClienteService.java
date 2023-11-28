package com.udea.domicilios.service;

import com.udea.domicilios.dao.IClienteDAO;
import com.udea.domicilios.model.Cliente;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private IClienteDAO dao;

    public void save(Cliente t) {
        dao.save(t);
    }

    @Transactional
    public String delete(int id) {
        dao.deleteById(id);
        return "Cliente con ID "+ id + "eliminado";
    }

    @Transactional
    public String deleteCedula(String cedula) {
        dao.deleteByCedula(cedula);
        return "Cliente con cedula "+ cedula + "eliminado";
    }

    public Iterable<Cliente> list() {
        return dao.findAll();
    }

    public Optional<Cliente> listId(int id) {
        return dao.findById(id);
    }

    public Optional<Cliente> listCedula(String cedula) {
        return dao.findByCedula(cedula);
    }

    public Cliente update(Cliente d) {
        Cliente existingCliente = dao.findById(d.getIdCliente()).orElse(null);
        existingCliente.setNombre(d.getNombre());
        existingCliente.setApellido(d.getApellido());
        existingCliente.setCedula(d.getCedula());
        existingCliente.setCelular(d.getCelular());
        existingCliente.setEmail(d.getEmail());
        existingCliente.setEdad(d.getEdad());
        existingCliente.setNumPedidos(d.getNumPedidos());
        return dao.save(existingCliente);
    }
}
