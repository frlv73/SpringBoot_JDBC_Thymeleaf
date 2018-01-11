package com.leonel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonel.dao.IMarcaDAO;
import com.leonel.model.Marca;

@Service
public class MarcaService implements IMarcaService{
	
	IMarcaDAO dao;

	@Autowired
	public void setDao(IMarcaDAO dao) {
		this.dao = dao;
	}

	public List<Marca> getAllMarcas() {
		
		return dao.getAllMarcas();
	}

	@Override
	public void addMarca(Marca marca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMarca(Marca marca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMarca(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marca findMarcaByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca findMarcaByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
