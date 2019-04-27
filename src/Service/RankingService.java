package Service;

import Dao.RankingDao;
import Model.RankingModel;
import Model.RankingModelArray;

public class RankingService {
	private RankingDao dao;
	
	public RankingService() {
		dao = new RankingDao();
	}
	
	public void insert(RankingModel to) {
		dao.insert(to);
	}
	
	public void loadRecordistas(RankingModelArray array) {
		dao.loadRecordistas(array);
	}
}
