package tdd;

public class Entry 
{
    private String data;
    
    public Entry(){
    	data="Data has not been asigned";
    }
    
    public Entry(String dataX){
    	data= dataX;
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
