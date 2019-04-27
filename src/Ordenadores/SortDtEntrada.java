package Ordenadores;

import java.util.Comparator;

import Model.Processo;

public class SortDtEntrada implements Comparator<Processo> {
	public int compare(Processo o1, Processo o2) {
        if (o1.getDtEntrada().before(o2.getDtEntrada()))
        	return -1;
        else if (o1.getDtEntrada().after(o2.getDtEntrada()))
        	return +1;
        else
        	return 0;
	}
}
