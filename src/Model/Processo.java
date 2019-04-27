package Model;

import java.util.Date;

public class Processo {
	private int		duracao, prioridade;
	private String	descricao;
	private char	estado;
	private Date	dtEntrada;
	
	public Processo(int duracao, int prioridade, String descricao, char estado) {
		this.duracao = duracao;
		this.prioridade = prioridade;
		this.descricao = descricao;
		this.estado = estado;
		this.dtEntrada = new Date();
	}
	
	public Processo() {
		this.duracao = -1;
		this.prioridade = 1;
		this.descricao = "";
		this.estado = 'b';
	}
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	@Override
	public String toString() {
		return "\nProcesso [\nduracao=" + duracao + ", \nprioridade=" + prioridade + ", \ndescricao=" + descricao + ", \nestado="
				+ estado + ", \ndtEntrada=" + dtEntrada + "]";
	}
}
