package com.leonel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonel.dao.IMarcaDAO;
import com.leonel.model.Marca;

@Service
public class MarcaService implements IMarcaService {

	@Autowired
	IMarcaDAO dao;

	public List<Marca> getAllMarcas() {

		return dao.getAllMarcas();
	}

	@Override
	public void addMarca(Marca marca) {
		dao.addMarca(marca);

	}

	@Override
	public void updateMarca(Marca marca) {
		dao.updateMarca(marca);

	}

	@Override
	public void deleteMarca(int id) {
		dao.deleteMarca(id);

	}

	@Override
	public Marca findMarcaByName(String nombre) {
		return dao.findMarcaByName(nombre);
	}

	@Override
	public Marca findMarcaByID(int id) {
		return dao.findMarcaByID(id);
	}

}
