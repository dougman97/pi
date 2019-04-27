package Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RankingModel implements Serializable {
	private int 		ranking_id, dados_salvos_id, dificuldade, pontuacao;
	private	Timestamp 	jogado_em;

	public RankingModel(int ranking_id, int dados_salvos_id, int dificuldade, int pontuacao, Timestamp jogado_em) {
		this.ranking_id = ranking_id;
		this.dados_salvos_id = dados_salvos_id;
		this.dificuldade = dificuldade;
		this.pontuacao = pontuacao;
		this.jogado_em = jogado_em;
	}

	public RankingModel() {
		this(-1, -1, 0, 0, null);
	}
	
	public int getRanking_id() {
		return ranking_id;
	}
	
	public void setRanking_id(int ranking_id) {
		this.ranking_id = ranking_id;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public int getDados_salvos_id() {
		return dados_salvos_id;
	}
	
	public void setDados_salvos_id(int dados_salvos_id) {
		this.dados_salvos_id = dados_salvos_id;
	}
	
	public Timestamp getJogado_em() {
		return jogado_em;
	}
	
	public void setJogado_em(Timestamp jogado_em) {
		this.jogado_em = jogado_em;
	}
}
