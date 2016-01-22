package tdd;

import java.util.LinkedList;
import java.util.List;
import java.io.File;

public class RecFileList 
{
    private List<File> list;
    private int size;
    private int maxsize= 15;
    
    public RecFileList(){
    	list= new LinkedList<File>();
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
    /*This method works when a new file is open*/
    public void openFile(File file){
    	if(size <15){
    		if(list.contains(file)){
    				list.remove(file);
    		}
    		list.add(0, file);
    		size ++;
    	}
    	else{
    		if(list.contains(file)){
    			list.remove(file);
    		}
    		else{
    			list.remove(maxsize-1);
    			list.add(0, file);
    		}
    	}    		
    }
    /*This method tell us if the file is contains in the Recent File List*/  
    public boolean isInRecFileList(File file){
    	return list.contains(file);
    }
    /*This method tell us the position of the file*/
    public int getPosition(File file){
    	return list.indexOf(file);
    }       
          
}
