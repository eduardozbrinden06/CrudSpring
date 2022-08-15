package com.example.crudclientes.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crudclientes.modelo.Clientes;

@Repository
public interface IClientes extends CrudRepository<Clientes, Integer> {

}
