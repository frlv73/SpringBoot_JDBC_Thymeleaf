package com.leonel.model;

public class Marca {

	private int id;
	private String nombre;

	public Marca() {
		super();
	}

	public Marca(int id) {
		this.setId(id);
	}

	public Marca(String nombre) {
		this.setNombre(nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
