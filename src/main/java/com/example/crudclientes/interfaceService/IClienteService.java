package com.example.crudclientes.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.crudclientes.modelo.Clientes;

//metodos del Crud
public interface IClienteService {
	public List<Clientes>listar();
	public Optional<Clientes>listarId(int id);
	public int save(Clientes c);
	public void delete(int id);
}
