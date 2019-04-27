package Model;

import java.util.Collections;
import java.util.Random;

import Ordenadores.SortDtEntrada;
import Ordenadores.SortDuracao;
import Ordenadores.SortPrioridade;

public class Cpu {
	private Processo processo;
	private int quantum;
	
	public Cpu() {
		processo = new Processo();
		quantum = 0;
	}
	
	public Processo getProcesso() {
		return processo;
	}

	public int getQuantum() {
		return quantum;
	}

	public void selectEscalonador(Memoria memoria) {
		Random rdm = new Random();
		int i = rdm.nextInt(3);
		
		switch(i) {
			case 0:
				firstComeFirstServed(memoria);
				break;
			case 1:
				shortestJobFirst(memoria);
				break;
			case 2:
				porPrioridade(memoria);
				break;
		}
	}
	
	private void firstComeFirstServed(Memoria memoria) {
		Collections.sort(memoria.getFila(), new SortDtEntrada());
	}
	
	private void shortestJobFirst(Memoria memoria) {
		Collections.sort(memoria.getFila(), new SortDuracao());
	}
	
	private void porPrioridade(Memoria memoria) {
		Collections.sort(memoria.getFila(), new SortPrioridade());
	}
	
	public void executaProcesso(Memoria memoria) throws InterruptedException {
		processo = memoria.removeProcesso(0);
		quantum = processo.getDuracao();
		
		if(quantum > processo.getDuracao())
			quantum = processo.getDuracao();
		
		for(int timer = quantum; timer > 0; timer--) {
			processo.setDuracao(processo.getDuracao() - 1);
		}
		
		if(processo.getDuracao() > 0)
			memoria.addProcesso(processo);
	}
}
