package com.leonel.dao;

import java.util.List;

import com.leonel.model.Marca;

public interface IMarcaDAO {
	public List<Marca> getAllMarcas();
	public void addMarca(Marca marca);
	public void updateMarca(Marca marca);
	public void deleteMarca(int id);
	public Marca findMarcaByName(String nombre);
	public Marca findMarcaByID(int id);
}
