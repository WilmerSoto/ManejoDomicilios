package com.udea.domicilios.dao;

import com.udea.domicilios.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoDAO extends CrudRepository<Pedido, Integer> {
}