package com.leonel.service;

import java.util.List;

import com.leonel.model.Marca;

public interface IMarcaService {
	public List<Marca> getAllMarcas();
	public void addMarca(Marca marca);
	public void updateMarca(Marca marca);
	public void deleteMarca(int id);
	public Marca findMarcaByName(String nombre);
	public Marca findMarcaByID(int id);
}
