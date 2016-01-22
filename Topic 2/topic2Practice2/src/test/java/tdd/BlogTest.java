package tdd;

import org.junit.*;


public class BlogTest{
    @Test
    public void newBlogEmpty(){
    	Blog blogTest1= new Blog();
    	Assert.assertNotNull("The blog shouldn't be null", blogTest1);
    	Assert.assertTrue("The blog should be empty!", blogTest1.isEmpty());
    }
    
    @Test
	public void incrementListSize(){
		Blog blogTest2= new Blog();
		Entry testEntry1= new Entry();
		Entry testEntry2= new Entry();
		Entry testEntry3= new Entry();
		Entry testEntry4= new Entry();
		Entry testEntry5= new Entry();
		blogTest2.addNewEntry(testEntry1);
		Assert.assertTrue(1== blogTest2.getSize());
		blogTest2.addNewEntry(testEntry2);
		Assert.assertTrue(2== blogTest2.getSize());
		blogTest2.addNewEntry(testEntry3);
		Assert.assertTrue(3== blogTest2.getSize());
		blogTest2.addNewEntry(testEntry4);
		Assert.assertTrue(4== blogTest2.getSize());
		blogTest2.addNewEntry(testEntry5);
		Assert.assertTrue(5== blogTest2.getSize());			
		
	}
    
    @Test
    public void newEntryAddedOnTop(){
    	Blog blogTest3= new Blog();
    	Entry testEntry6= new Entry();
    	Entry testEntry7= new Entry();
    	Entry testEntry8= new Entry();
    	blogTest3.addNewEntry(testEntry6);
    	Assert.assertTrue("This entry should be in the first position", blogTest3.getPosition(testEntry6)==0);
    	blogTest3.addNewEntry(testEntry7);
    	Assert.assertTrue("This entry should be in the first position", blogTest3.getPosition(testEntry7)==0);
    	blogTest3.addNewEntry(testEntry8);
    	Assert.assertTrue("This entry should be in the first position", blogTest3.getPosition(testEntry8)==0);
    }
    
    

}
