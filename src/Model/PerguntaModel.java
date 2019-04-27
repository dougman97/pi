package Model;

import java.io.Serializable;

public class PerguntaModel implements Serializable {
	private int 	enunciado_id, alternativa_id, dificuldade, capitulo_tema;
	private String 	enunciado_text, alternativa_text;
	private boolean resultado;
	
	public PerguntaModel(int enunciado_id, String enunciado_text, int dificuldade, int capitulo_tema, int alternativa_id, String alternativa_text, boolean resultado) {
		setEnunciado_id		(enunciado_id		);
		setEnunciado_text	(enunciado_text		);
		setDificuldade		(dificuldade		);
		setCapitulo_tema	(capitulo_tema		);
		setAlternativa_id	(alternativa_id		);
		setAlternativa_text	(alternativa_text	);
		setResultado		(resultado			);
	}
	
	public PerguntaModel() {
		this.enunciado_id = -1;
	}
	
	public PerguntaModel(PerguntaModel pm) {
		setEnunciado_id		(pm.getEnunciado_id()		);
		setEnunciado_text	(pm.getEnunciado_text()		);
		setDificuldade		(pm.getDificuldade()		);
		setCapitulo_tema	(pm.getCapitulo_tema()		);
		setAlternativa_id	(pm.getAlternativa_id()		);
		setAlternativa_text	(pm.getAlternativa_text()	);
		setResultado		(pm.getResultado()			);
	}

	public int getEnunciado_id() {
		return enunciado_id;
	}

	public void setEnunciado_id(int enunciado_id) {
		this.enunciado_id = enunciado_id;
	}

	public String getEnunciado_text() {
		return enunciado_text;
	}

	public void setEnunciado_text(String enunciado_text) {
		this.enunciado_text = enunciado_text;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public int getCapitulo_tema() {
		return capitulo_tema;
	}

	public void setCapitulo_tema(int capitulo_tema) {
		this.capitulo_tema = capitulo_tema;
	}

	public int getAlternativa_id() {
		return alternativa_id;
	}

	public void setAlternativa_id(int alternativa_id) {
		this.alternativa_id = alternativa_id;
	}
	
	public String getAlternativa_text() {
		return alternativa_text;
	}

	public void setAlternativa_text(String alternativa_text) {
		this.alternativa_text = alternativa_text;
	}

	public boolean getResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alternativa_id;
		result = prime * result + ((alternativa_text == null) ? 0 : alternativa_text.hashCode());
		result = prime * result + capitulo_tema;
		result = prime * result + dificuldade;
		result = prime * result + enunciado_id;
		result = prime * result + ((enunciado_text == null) ? 0 : enunciado_text.hashCode());
		result = prime * result + (resultado ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerguntaModel other = (PerguntaModel) obj;
		if (alternativa_id != other.alternativa_id)
			return false;
		if (alternativa_text == null) {
			if (other.alternativa_text != null)
				return false;
		} else if (!alternativa_text.equals(other.alternativa_text))
			return false;
		if (capitulo_tema != other.capitulo_tema)
			return false;
		if (dificuldade != other.dificuldade)
			return false;
		if (enunciado_id != other.enunciado_id)
			return false;
		if (enunciado_text == null) {
			if (other.enunciado_text != null)
				return false;
		} else if (!enunciado_text.equals(other.enunciado_text))
			return false;
		if (resultado != other.resultado)
			return false;
		return true;
	}
}
