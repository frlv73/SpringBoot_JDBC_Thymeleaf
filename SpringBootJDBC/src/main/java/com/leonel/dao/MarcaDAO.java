package com.leonel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.leonel.model.Marca;

@Repository
public class MarcaDAO implements IMarcaDAO {

	// Definición de consultas a la BD
	private static String SQL_BUSCAR_TODOS = "SELECT * FROM marcas";
	private static String SQL_INSERTAR = "INSERT INTO marcas(idmarca, nombre) VALUES (:id, :nombre)";
	private static String SQL_ACTUALIZAR = "UPDATE marcas SET nombre = :nombre WHERE idmarca = :id";
	private static String SQL_ELIMINAR = "DELETE FROM marcas WHERE idmarca = :id";
	private static String SQL_BUSCAR_POR_NOMBRE = "SELECT * FROM marcas WHERE nombre LIKE %:nombre%";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM marcas WHERE idmarca = :id";

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	// Recuperar todas las marcas
	@Override
	public List<Marca> getAllMarcas() {
		// En query se envía la consulta. No recibe ningún parámetro y mapea las filas a
		// objetos Marca
		List<Marca> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODOS, getSqlParameterByModel(null),
				new MarcaMapper());
		return lista;
	}

	// Insertar una marca
	@Override
	public void addMarca(Marca marca) {
		namedParameterJdbcTemplate.update(SQL_INSERTAR, getSqlParameterByModel(marca));

	}

	// Actualizar una marca
	@Override
	public void updateMarca(Marca marca) {
		namedParameterJdbcTemplate.update(SQL_ACTUALIZAR, getSqlParameterByModel(marca));

	}

	// Borrar una marca
	@Override
	public void deleteMarca(int id) {
		namedParameterJdbcTemplate.update(SQL_ELIMINAR, getSqlParameterByModel(new Marca(id)));

	}

	// Buscar marca por nombre
	@Override
	public Marca findMarcaByName(String nombre) {
		// Se envía la consulta y se pasa como parámetro la marca con el nombre que se
		// quiere buscar
		Marca marca = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_NOMBRE,
				getSqlParameterByModel(new Marca(nombre)), new MarcaMapper());
		return marca;
	}

	// Buscar marca por id
	@Override
	public Marca findMarcaByID(int id) {
		Marca marca = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_ID,
				getSqlParameterByModel(new Marca(id)), new MarcaMapper());
		return marca;
	}

	// Recibe un objeto Marca y define los parámetros que se pasan a las consultas a
	// partir de sus propiedades
	private SqlParameterSource getSqlParameterByModel(Marca marca) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (marca != null) {
			paramSource.addValue("id", marca.getId());
			paramSource.addValue("nombre", marca.getNombre());
		}
		return paramSource;
	}

	// Mapea las filas obtenidas de la BD a las propiedades de un objeto Marca
	private static final class MarcaMapper implements RowMapper<Marca> {
		public Marca mapRow(ResultSet rs, int rowNum) throws SQLException {
			Marca marca = new Marca();
			marca.setId(rs.getInt("idmarca"));
			marca.setNombre(rs.getString("nombre"));
			return marca;
		}
	}

}
