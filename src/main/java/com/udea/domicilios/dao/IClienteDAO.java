package com.udea.domicilios.dao;

import com.udea.domicilios.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IClienteDAO extends CrudRepository<Cliente, Integer> {
    Optional<Cliente> findByCedula(String cedula);
    void deleteByCedula(String cedula);
}