package com.tdd.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToArabicTest {

	@Test
	public void testForConvert_I_to_1() {
		
		assertEquals(new Roman("I").toArabic(), 1);		
	}
	
	@Test
	public void testForConvert_II_to_2() {
		
		assertEquals(new Roman("II").toArabic(), 2);		
	}
	
	@Test
	public void testForConvert_V_to_5() {
		
		assertEquals(new Roman("V").toArabic(), 5);		
	}
	
	@Test
	public void testForConvert_X_to_10() {
		
		assertEquals(new Roman("X").toArabic(), 10);		
	}
	
	@Test
	public void testForConvert_IV_to_4() {
		
		assertEquals(new Roman("IV").toArabic(), 4);		
	}
	

}
