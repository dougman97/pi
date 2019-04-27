package Model;
import java.util.ArrayList;

public class Memoria {
	private ArrayList<Processo> fila;
	
	public ArrayList<Processo> getFila() {
		return fila;
	}

	public void setFila(ArrayList<Processo> fila) {
		this.fila = fila;
	}

	public Memoria() {
		fila = new ArrayList<>();
	}
	
	public void addProcesso(Processo processo) {
		fila.add(processo);
	}
	
	public Processo removeProcesso(int posicao) {
		return fila.remove(posicao);
	}
	
	public int totalProcessos() {
		return fila.size();
	}
	
	public boolean isEmpty() {
		return totalProcessos() == 0;
	}
	
	public int esperaTotal() {
		int burst = 0;
		
		for(int i = 0; i < fila.size() - 1; i++)
			burst += fila.get(i).getDuracao();
		
		return burst;
	}
	
	public int mediaEspera() {
		if(!isEmpty())
			return esperaTotal() / totalProcessos();
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "Memoria [fila=" + fila + "]"
				+ "\nTempo de espera: " + esperaTotal() + " ms"
				+ "\nMédia de espera: " + mediaEspera() + " ms";
	}
}
