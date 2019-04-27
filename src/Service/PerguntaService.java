package Service;

import Dao.PerguntaDao;
import Model.PerguntaModelArray;

public class PerguntaService {
	private PerguntaDao dao;
	
	public PerguntaService() {
		dao = new PerguntaDao();
	}
	
	/**
	 * Esse metodo busca da base de dados um array de 10 enunciados, ordenados aleatoriamente.
	 * @param arg1 Coluna que sera usada como ferramenta de busca, sendo:
	 * 		<br> 0 = Capitulo
	 * 		<br> 1 = Dificuldade
	 * @param arg2 Se:
	 * 		<br> arg1 for 0 (Capitulo), esse parametro indicara qual capitulo os enunciados se referem (0 a N)
	 * 		<br> args2 for 1 (Dificuldade), esse parametro indicara o nivel da dificuldade que serao buscados (1 a 3)
	 * @return Array de 10 posicoes ordenado aleatoriamente
	 */
	public PerguntaModelArray[] loadEnunciados(int arg1, int arg2) {
		return dao.loadEnunciados(arg1, arg2);
	}
}
