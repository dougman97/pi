package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Factory.CursoSOFactory;
import Model.DadosSalvosModel;

public class DadosSalvosDao {
	public void insert(DadosSalvosModel to) {
		String sqlInsert = "INSERT INTO dados_salvos(nome) VALUES(?)";
		
		try (Connection conn = CursoSOFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString		(1, to.getNome());
			String sqlQuery = 	"SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				
				if(rs.next()){
					to.setDados_salvos_id(rs.getInt(1));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
}
