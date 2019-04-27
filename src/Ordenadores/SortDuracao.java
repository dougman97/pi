package Ordenadores;

import java.util.Comparator;

import Model.Processo;

public class SortDuracao implements Comparator<Processo> {
    public int compare(Processo o1, Processo o2) {
        if (o1.getDuracao() < o2.getDuracao())
        	return -1;
        else if (o1.getDuracao() > o2.getDuracao())
        	return +1;
        else
        	return 0;
	}
}
