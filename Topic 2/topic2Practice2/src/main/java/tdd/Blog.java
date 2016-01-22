package tdd;

import java.util.*;

public class Blog {
	private List<Entry> entryList= null;
	private int size;
	private int maxsize= 10;
	
	public Blog(){
		entryList= new LinkedList<Entry>();
		size= 0;
	}
	
	/*This method tell us if the list is empty.*/
    	public boolean isEmpty(){
    		if(size==0)
    			return true;
    				return false;
    }
		
		/*This method return us the size of the list*/
	    public int getSize(){
	    	return size;
	    }
	    /*This method adds a new entry*/
	    public void addNewEntry(Entry e){
	    	if(size<maxsize){
	    		size++;
	    	}
	    	else{
	    		entryList.remove(maxsize-1);
	    	}
	    	entryList.add(0, e);
	    }
	    /*This method removes an entry*/
	    public String removeEntry(Entry e){
	    	if(size>0 && entryList.contains(e)){
	    		entryList.remove(e);
	    		size--;
	    		return "The entry has been removed.";
	    	}
	    	else return "The entry has not found.";
	    }
	    
	    /*This method tell us the position of the entry*/
	    public int getPosition(Entry e){
	    	return entryList.indexOf(e);
	    }
	    
	    /*This method tell us if the entry is contains in the Entry List*/  
	    public boolean isInRecFileList(Entry e){
	    	return entryList.contains(e);
	    }
	    
}
