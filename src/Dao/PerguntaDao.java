package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Factory.CursoSOFactory;
import Model.PerguntaModel;
import Model.PerguntaModelArray;

public class PerguntaDao {
	/**
	 * Metodo que recolhe da base de dados um conjunto de 10 ids de enunciados.
	 * @param arg1 Coluna que sera usada como ferramenta de busca, sendo:
	 * 		0 = Capitulo
	 * 		1 = Dificuldade
	 * @param arg2 Se:
	 * 		arg1 for 0 (Capitulo), esse parametro indicara qual capitulo os enunciados se referem (0 a N)
	 * 		args2 for 1 (Dificuldade), esse parametro indicara o nivel da dificuldade que serao buscados (1 a 3)
	 * @return Array de 10 posicoes ordenado aleatoriamente
	 */
	public PerguntaModelArray[] loadEnunciados(int arg1, int arg2) {
		PerguntaModelArray[] 	modelArray;
		String 					sqlSelect, tipo;
		
		modelArray = new PerguntaModelArray[0];
		tipo = (arg1 == 0 ? "capitulo" : (arg1 == 1 ? "dificuldade_id" : "")); 
		sqlSelect = "SELECT enunciado_id FROM enunciado WHERE " + tipo + " = ? ORDER BY RAND() LIMIT 10";
		
		try (Connection conn = CursoSOFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
						
			int[] vetorId;
			
			stm.setInt(1, arg2);
			vetorId = new int[10];
			
			try (ResultSet rs = stm.executeQuery();) {
				int i;
				i = 0;
				
				while(rs.next()){
					vetorId[i++] = rs.getInt(1);
				}
				
				//Caso traga menos de 10 enunciados, passa os valores para um vetor menor
				if (i < 9) {
					int[] vetorAux;
					vetorAux = vetorId;
					vetorId = new int[i];
					
					for (int j = 0; j < vetorId.length; j++)
						vetorId[j] = vetorAux[j];
				}
				
				modelArray = new PerguntaModelArray[vetorId.length];
				
				for (int j = 0; j < modelArray.length; j++)
					modelArray[j] = loadAlternativas(vetorId[j]);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelArray;
	}
	
	//Carregar array com Alternativas
	public PerguntaModelArray loadAlternativas(int id) {
		PerguntaModelArray 	array;
		PerguntaModel 		to;
		String 				sqlSelect;
		
		array = new PerguntaModelArray();
		sqlSelect = "SELECT e.enunciado_text, e.dificuldade_id, e.capitulo_tema, "
				+ "a.alternativa_id, a.alternativa_text, a.resultado "
				+ "FROM enunciado e INNER JOIN alternativa a "
				+ "ON e.enunciado_id = a.enunciado_id WHERE e.enunciado_id = ? "
				+ "ORDER BY Rand()";
		
		try (Connection conn = CursoSOFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new PerguntaModel();
					to.setEnunciado_id		(id);
					to.setEnunciado_text	(rs.getString	("e.enunciado_text"		));
					to.setDificuldade		(rs.getInt		("e.dificuldade_id"		));
					to.setCapitulo_tema		(rs.getInt		("e.capitulo_tema"		));
					to.setAlternativa_id	(rs.getInt		("a.alternativa_id"		));
					to.setAlternativa_text	(rs.getString	("a.alternativa_text"	));
					to.setResultado			(rs.getBoolean	("a.resultado"			));
					array.getArray().add	(to);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return array;
	}
}
