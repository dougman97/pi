package Service;

import Dao.DadosSalvosDao;
import Model.DadosSalvosModel;

public class DadosSalvosService {
	private DadosSalvosDao dao;

	public DadosSalvosService() {
		dao = new DadosSalvosDao();
	}
	
	public void insert(DadosSalvosModel to) {
		dao.insert(to);
	}
}
