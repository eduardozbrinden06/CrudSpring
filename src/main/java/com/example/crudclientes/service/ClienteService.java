package com.example.crudclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudclientes.interfaceService.IClienteService;
import com.example.crudclientes.interfaces.IClientes;
import com.example.crudclientes.modelo.Clientes;


//Implementación de los metodos 

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClientes data;
	
	@Override
	public List<Clientes> listar() {
		return (List<Clientes>) data.findAll() ;
	}

	@Override
	public Optional<Clientes> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Clientes c) {
		int res = 0;
		Clientes clientes = data.save(c);
		if (!clientes.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);		
	}

}
