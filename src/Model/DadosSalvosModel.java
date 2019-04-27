package Model;

import java.sql.Timestamp;

public class DadosSalvosModel {
	private int 		dados_salvos_id, capitulo_atual, cenario_atual;
	private String 		nome;
	private Timestamp 	criado_em, salvo_em;
	private double 		nota_cap_1, nota_cap_2, nota_cap_3, nota_cap_4, nota_cap_5, nota_cap_6;
	
	public DadosSalvosModel(int dados_salvos_id, int capitulo_atual, int cenario_atual, String nome, Timestamp criado_em,
			Timestamp salvo_em, double nota_cap_1, double nota_cap_2, double nota_cap_3, double nota_cap_4,
			double nota_cap_5, double nota_cap_6) {
		
		this.dados_salvos_id 	= dados_salvos_id;
		this.capitulo_atual 	= capitulo_atual;
		this.cenario_atual 		= cenario_atual;
		this.nome 				= nome;
		this.criado_em 			= criado_em;
		this.salvo_em 			= salvo_em;
		this.nota_cap_1 		= nota_cap_1;
		this.nota_cap_2 		= nota_cap_2;
		this.nota_cap_3 		= nota_cap_3;
		this.nota_cap_4 		= nota_cap_4;
		this.nota_cap_5 		= nota_cap_5;
		this.nota_cap_6 		= nota_cap_6;
	}

	public int getDados_salvos_id() {
		return dados_salvos_id;
	}

	public void setDados_salvos_id(int dados_salvos_id) {
		this.dados_salvos_id = dados_salvos_id;
	}

	public int getCapitulo_atual() {
		return capitulo_atual;
	}

	public void setCapitulo_atual(int capitulo_atual) {
		this.capitulo_atual = capitulo_atual;
	}

	public int getCenario_atual() {
		return cenario_atual;
	}

	public void setCenario_atual(int cenario_atual) {
		this.cenario_atual = cenario_atual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Timestamp getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Timestamp criado_em) {
		this.criado_em = criado_em;
	}

	public Timestamp getSalvo_em() {
		return salvo_em;
	}

	public void setSalvo_em(Timestamp salvo_em) {
		this.salvo_em = salvo_em;
	}

	public double getNota_cap_1() {
		return nota_cap_1;
	}

	public void setNota_cap_1(double nota_cap_1) {
		this.nota_cap_1 = nota_cap_1;
	}

	public double getNota_cap_2() {
		return nota_cap_2;
	}

	public void setNota_cap_2(double nota_cap_2) {
		this.nota_cap_2 = nota_cap_2;
	}

	public double getNota_cap_3() {
		return nota_cap_3;
	}

	public void setNota_cap_3(double nota_cap_3) {
		this.nota_cap_3 = nota_cap_3;
	}

	public double getNota_cap_4() {
		return nota_cap_4;
	}

	public void setNota_cap_4(double nota_cap_4) {
		this.nota_cap_4 = nota_cap_4;
	}

	public double getNota_cap_5() {
		return nota_cap_5;
	}

	public void setNota_cap_5(double nota_cap_5) {
		this.nota_cap_5 = nota_cap_5;
	}

	public double getNota_cap_6() {
		return nota_cap_6;
	}

	public void setNota_cap_6(double nota_cap_6) {
		this.nota_cap_6 = nota_cap_6;
	}
}
