package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class RankingModelArray implements Serializable {
	private ArrayList<RankingModel> array = new ArrayList<RankingModel>();
	
	public ArrayList<RankingModel> getArray() {
		return array;
	}

	public void setArray(ArrayList<RankingModel> array) {
		this.array = array;
	}	
}
