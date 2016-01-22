package tdd;

import org.junit.*;
import java.io.File;


public class RecFileListTest 
    
{
	@Test
	public void listIsEmptyBeforeCreation(){
		RecFileList testList= new RecFileList();
		Assert.assertTrue("The List should be empty", testList.isEmpty());
	}
	
	@Test
	public void incrementListSize(){
		RecFileList testList1= new RecFileList();
		File testFileA= new File("~/testFileA.txt");
		File testFileB= new File("~/testFileB.txt");
		File testFileC= new File("~/testFileC.txt");
		File testFileD= new File("~/testFileD.txt");
		File testFileE= new File("~/testFileE.txt");
		testList1.openFile(testFileA);
		Assert.assertTrue(1== testList1.getSize());
		testList1.openFile(testFileB);
		Assert.assertTrue(2== testList1.getSize());
		testList1.openFile(testFileC);
		Assert.assertTrue(3== testList1.getSize());
		testList1.openFile(testFileC);
		Assert.assertTrue(4== testList1.getSize());
		testList1.openFile(testFileD);
		Assert.assertTrue(5== testList1.getSize());
		testList1.openFile(testFileE);		
		
	}
	
	@Test
	public void anOpenedFileIsInsertIntoTheList(){
		RecFileList testList2= new RecFileList();
		File testFileF= new File("~/testFileF.txt");
		File testFileG= new File("~/testFileG.txt");
		File testFileH= new File("~/testFileH.txt");
		testList2.openFile(testFileF);
		testList2.openFile(testFileG);
		testList2.openFile(testFileH);
		Assert.assertTrue("The file now is in the Recent File List", testList2.isInRecFileList(testFileF));
		Assert.assertTrue("The file now is in the Recent File List", testList2.isInRecFileList(testFileG));
		Assert.assertTrue("The file now is in the Recent File List", testList2.isInRecFileList(testFileH));
		
	}
	
	@Test
	public void anOpenedFileInsertedIntoTheListIsOnTop(){
		RecFileList testList3= new RecFileList();
		File testFileI= new File("~/testFileI.txt");
		File testFileJ= new File("~/testFileJ.txt");
		File testFileK= new File("~/testFileK.txt");
		File testFileL= new File("~/testFileL.txt");	
		testList3.openFile(testFileI);
		boolean ban= (0 == testList3.getPosition(testFileI));
		testList3.openFile(testFileJ);
		ban= ban && (0== testList3.getPosition(testFileJ));
		testList3.openFile(testFileK);
		ban= ban && (0== testList3.getPosition(testFileK));
		testList3.openFile(testFileL);
		ban= ban && (0== testList3.getPosition(testFileL));
		Assert.assertTrue("Order error", ban);
		
	}
	
	
	
	
    
}
