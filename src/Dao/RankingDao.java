package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Factory.CursoSOFactory;
import Model.RankingModel;
import Model.RankingModelArray;

public class RankingDao {
	//insert jogada
	public void insert(RankingModel to) {
		String sqlInsert = "INSERT INTO ranking(dados_salvos_id, dificuldade, pontuacao) VALUES(?,?,?)";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = CursoSOFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt			(1, to.getDados_salvos_id()	);
			stm.setInt			(2, to.getDificuldade()		);
			stm.setInt			(3, to.getPontuacao()		);
			String sqlQuery = 	"SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					to.setRanking_id(rs.getInt(1));
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
	
	//Carregar array
	public void loadRecordistas(RankingModelArray array) {
		RankingModel to = new RankingModel();
		String sqlSelect;
		
		to = new RankingModel();
		sqlSelect = "SELECT ranking_id, dados_salvos_id, pontuacao, jogado_em"
				+ " FROM ranking ORDER BY pontuacao DESC";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = CursoSOFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getRanking_id());
			try (ResultSet rs = stm.executeQuery();) {
				int i = 0;
				while (rs.next()) {
					to.setDados_salvos_id	(rs.getInt		("dados_salvos_id")	);
					to.setDificuldade		(rs.getInt		("dificuldade")		);
					to.setPontuacao			(rs.getInt		("pontuacao")		);
					to.setJogado_em			(rs.getTimestamp("jogado_em")		);
					array.getArray().add(to);
					i++;
				}
				if (i == 0) {
					to.setRanking_id(-1);
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
