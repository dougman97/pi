package Ordenadores;

import java.util.Comparator;

import Model.Processo;

public class SortPrioridade implements Comparator<Processo> {
    public int compare(Processo o1, Processo o2) {
        if (o1.getPrioridade() < o2.getPrioridade())
        	return -1;
        else if (o1.getPrioridade() > o2.getPrioridade())
        	return +1;
        else
        	return 0;
	}
}