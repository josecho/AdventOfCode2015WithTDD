package com.adventofcode;

import static org.junit.Assert.*;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import com.adventofcode.day2.WrappingPaper;

public class WrappingPaperTest {

	private static final Logger logger = Logger.getLogger(WrappingPaperTest.class.getName());
	
	WrappingPaper wrappingPaper = new WrappingPaper();
	List<String> opetationsList;
	String opertation;
	
	
	@Test
	public void testGetListOperations() {
		logger.info("Obtendo lista de operacions matemáticas");
		List<String> opetationsList;
		opetationsList = wrappingPaper.getOperationsList();
		System.out.println(opetationsList);
		assertNotNull(opetationsList);
	}
	
	@Test
	public void splitDimenionInOperands(){
		logger.info("Split String Dimension to Integers operands");
		String dimension = "2x3x4";
		int[] operandsList = wrappingPaper.splitDimensionInOperands(dimension);
		System.out.println("First Operand:" + operandsList[0] + " Second Operand:" + operandsList[1]
				+ " Third Operand:" + operandsList[2]);
		assertNotNull(operandsList);
	}
	
	
	@Test
	public void testSurfaceAreaOfBox() {
		logger.info("testCalculateSurfaceAreaOfBox  2*l*w + 2*w*h + 2*h*l");
		String dimension = "2x3x4";
		Integer result = wrappingPaper.calculateSurfaceArea(dimension);
		System.out.println("Restult:" + result);  
		assertEquals("Invalid result",(Integer)52, (Integer)result);
		dimension = "1x1x10";
		result = wrappingPaper.calculateSurfaceArea(dimension);
		System.out.println("Restult:" + result);  
		assertEquals("Invalid result",(Integer)42, (Integer)result);
	}
	
	
	@Test
	public void testAreaSmallestSide() {
		logger.info("------------------testAreaSmallestSide----------------- ");
		String dimension = "2x3x4";
		int result = wrappingPaper.calculateAreaSmallestSide(dimension);  
		assertEquals("Invalid result",(Integer)6, (Integer)result);
		dimension = "3x4x2";
		result = wrappingPaper.calculateAreaSmallestSide(dimension);  
		assertEquals("Invalid result",(Integer)6, (Integer)result);
		dimension = "1x1x10";
		result = wrappingPaper.calculateAreaSmallestSide(dimension);  
		assertEquals("Invalid result",(Integer)1, (Integer)result);
		dimension = "12x12x2";
		result = wrappingPaper.calculateAreaSmallestSide(dimension);  
		assertEquals("Invalid result",(Integer)24, (Integer)result);
	}
	
	@Test
	public void testTotalAreaWrappingPaper() {
		logger.info("------------------testTotalAreaWrappingPaper--------------------- ");
		String dimension = "2x3x4";
		int result = wrappingPaper.calculateAreaWrappingPaperOnePackage(dimension);
		assertEquals("Invalid result",(Integer)58, (Integer)result);
		dimension = "1x1x10";
		result = wrappingPaper.calculateAreaWrappingPaperOnePackage(dimension);
		assertEquals("Invalid result",(Integer)43, (Integer)result);
		
	}
	
	@Test
	public void testAreaWrappingPaperAllPackage() {
		logger.info("------------------testAreaWrappingPaper   ****************AllPackage--------------------- ");
		List<String> opetationsList;
		opetationsList = wrappingPaper.getOperationsList();
		int result = wrappingPaper.getAreaWrappingPaperAllPackage(opetationsList);
		System.out.println(result);
		assertEquals("Invalid result",(Integer)1606483, (Integer)result);
		
	}
	
	@Test
	public void testShortesPerimeterItsSidesOnePacket() {
		logger.info("------------------testShortesPerimeterItsSidesOnePacket----------------- ");
		String dimension = "2x3x4";
		int result = wrappingPaper.calculateShortestPerimeterItsSidesOnePacket(dimension);  
		assertEquals("Invalid result",(Integer)10, (Integer)result);
		dimension = "1x1x10";
		result = wrappingPaper.calculateShortestPerimeterItsSidesOnePacket(dimension);  
		assertEquals("Invalid result",(Integer)4, (Integer)result);
		
	}
	
	@Test
	public void testShortestDistanceAroundItsSidesOnePacket() {
		logger.info("------------------testAreaSmallestSide----------------- ");
		String dimension = "2x3x4";
		int result = wrappingPaper.calculateShortestDistanceAroundItsSidesOnePacket(dimension);  
		assertEquals("Invalid result",(Integer)34, (Integer)result);
		dimension = "1x1x10";
		result = wrappingPaper.calculateShortestDistanceAroundItsSidesOnePacket(dimension);  
		assertEquals("Invalid result",(Integer)14, (Integer)result);
		
	}
	
	@Test
	public void testLengthAllRibbon() {
		logger.info("------------------testAreaWrappingPaper   ****************AllPackage--------------------- ");
		List<String> opetationsList;
		opetationsList = wrappingPaper.getOperationsList();
		int result = wrappingPaper.getLengthRibbonAllPackage(opetationsList);
		System.out.println(result);
		assertEquals("Invalid result",(Integer)3842356, (Integer)result);
		
	}
	
	

}


