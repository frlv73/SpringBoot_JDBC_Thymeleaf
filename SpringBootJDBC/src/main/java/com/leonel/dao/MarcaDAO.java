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

	private static String SQL_BUSCAR_TODOS = "SELECT * FROM marcas";
	//private static String SQL_INSERTAR = "INSERT INTO marcas(idmarca, nombre) VALUES (:id, :nombre)";
	//private static String SQL_ACTUALIZAR = "UPDATE marcas SET nombre = :nombre WHERE idmarca = :id";
	//private static String SQL_ELIMINAR = "DELETE FROM marcas WHERE id = :id";
	//private static String SQL_BUSCAR_POR_NOMBRE = "SELECT * FROM marcas WHERE nombre LIKE %:nombre%";

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public List<Marca> getAllMarcas() {
		// En query se envía la consulta. No recibe ningún parámetro y mapea las filas a objetos Marca
		List<Marca> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODOS, getSqlParameterByModel(null),
				new MarcaMapper());
		return lista;
	}

	// Recibe un objeto Marca y define los parámetros que se pasan a las consultas
	private SqlParameterSource getSqlParameterByModel(Marca marca) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (marca != null) {
			paramSource.addValue("id", marca.getId());
			paramSource.addValue("nombre", marca.getNombre());
		}
		return paramSource;
	}

	// Mapea las filas obtenidas de la BD a un objeto Marca
	private static final class MarcaMapper implements RowMapper<Marca> {
		public Marca mapRow(ResultSet rs, int rowNum) throws SQLException {
			Marca marca = new Marca();
			marca.setId(rs.getInt("idmarca"));
			marca.setNombre(rs.getString("nombre"));
			return marca;
		}
	}

}
