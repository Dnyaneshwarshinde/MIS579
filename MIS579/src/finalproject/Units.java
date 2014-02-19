package finalproject;
public enum Units {
	US(1), Metric(2);
	
	private int i;
	
	private Units(int i){
		this.i = i;
	}
	
	public int getCode(){
		return i;
	}
	
	public String toString(){
		switch (i) {
			case 1 : return "(ft)";
			case 2 : return "(m)";
			default : return "";
		}
	}
	
}

