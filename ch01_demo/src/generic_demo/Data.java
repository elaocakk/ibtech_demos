package generic_demo;

class DataBase <T> {
	
}

public class Data <T> extends DataBase implements IData {
	
	private T data;

	public Data(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

//	public void setData(T data) {
//		this.data = data;
//	}
	
	@Override
	public String toString() {
		return "data is:" + data;
	}

	@Override
	public void setData(Object t) {
		// TODO Auto-generated method stub
		
	}
	

	
}
