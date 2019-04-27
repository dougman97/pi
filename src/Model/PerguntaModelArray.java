package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PerguntaModelArray implements Serializable {
	private ArrayList<PerguntaModel> array = new ArrayList<PerguntaModel>();
	
	public ArrayList<PerguntaModel> getArray() {
		return array;
	}

	public void setArray(ArrayList<PerguntaModel> array) {
		this.array = array;
	}
	
	public PerguntaModel getAlternativa(int posicao) {
		if(posicao > -1 && posicao < array.size())
			return array.get(posicao);
		
		PerguntaModel p = new PerguntaModel();
		return p;
	}
	
	// Correta
	public PerguntaModel getAlternativaCorreta() {
		for(PerguntaModel a: array) {
			if(a.getResultado())
				return a;
		}
		PerguntaModel p = new PerguntaModel();
		return p;
	}
}
