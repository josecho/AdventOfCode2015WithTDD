package com.adventofcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.adventofcode.day6.GridMillionLights;
import com.adventofcode.day6.Ligth;

public class LightingConfigurationTest {
	
	private static final Logger logger = Logger.getLogger(GridHouseTest.class.getName());
	
	Ligth ligth;
	GridMillionLights gridMillionLights;
	List<String> orderList;
	
	@Before
	public void initTets(){
		ligth = new Ligth();
		gridMillionLights=new GridMillionLights();
		orderList = new ArrayList<String>();
	}
	
	@Test
	public void turnOnOneLigtTest() {
		logger.info("------------------turnOnOneLigtTest-------------------------------------");
		ligth.setTurn(true);
		assertTrue(ligth.isTurn());
	}
	
	@Test
	public void turnOffOneLigtTest() {
		logger.info("------------------turnOffOneLigtTest-------------------------------------");
		ligth.setTurn(false);
		assertFalse(ligth.isTurn());
	}
	
	@Test
	public void turnToogleOneLigtTest() {
		logger.info("------------------turnToogleOneLigtTest-------------------------------------");
		ligth.setTurn(true);
		ligth.toggle();
		assertFalse(ligth.isTurn());
		ligth.toggle();
		assertTrue(ligth.isTurn());
		ligth.toggle();
		assertFalse(ligth.isTurn());
	}
	
	@Test
	public void sizeGridMillionLights() {
		logger.info("------------------sizeGridMillionLights-------------------------------------");
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getSize());
	}
	
	@Test
	public void lights_all_start_turned_off() {
		logger.info("------------------lights_all_start_turned_off-------------------------------------");
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getlightsTurnedOff());
	}
	
	@Test
	public void lights_all_start_turned_on() {
		logger.info("------------------lights_all_start_turned_on-------------------------------------");
		assertEquals("Invalid result",(Integer)0, (Integer)gridMillionLights.getlightsTurnedOn());
	}
	
	@Test
	public void testGetListOrders() {
		logger.info("------------------testGetListOrders-------------------------------------");
		orderList = gridMillionLights.getOrderList();
		assertNotNull(orderList);
	}
	
	@Test
	public void identify_Orders_On() {
		logger.info("------------------identifyOrdersOn-------------------------------------");
		String orderOn = "turn on 0,0 through 999,999";
		Boolean result = gridMillionLights.isOrderOn(orderOn);
		assertTrue(result);
		orderOn = "turn off 539,243 through 559,965";
		result = gridMillionLights.isOrderOn(orderOn);
		assertFalse(result);
		orderOn = "toggle 831,394 through 904,860";
		result = gridMillionLights.isOrderOn(orderOn);
		assertFalse(result);
	}
	
	@Test
	public void identify_Orders_Off() {
		logger.info("------------------identifyOrdersOff-------------------------------------");
		String orderOn = "turn on 0,0 through 999,999";
		Boolean result = gridMillionLights.isOrderOff(orderOn);
		assertFalse(result);
		orderOn = "turn off 539,243 through 559,965";
		result = gridMillionLights.isOrderOff(orderOn);
		assertTrue(result);
		orderOn = "toggle 831,394 through 904,860";
		result = gridMillionLights.isOrderOff(orderOn);
		assertFalse(result);
	}
	
	@Test
	public void identify_Orders_Toggle() {
		logger.info("------------------identifyOrdersToggle-------------------------------------");
		String orderOn = "turn on 0,0 through 999,999";
		Boolean result = gridMillionLights.isOrderToggle(orderOn);
		assertFalse(result);
		orderOn = "turn off 539,243 through 559,965";
		result = gridMillionLights.isOrderToggle(orderOn);
		assertFalse(result);
		orderOn = "toggle 831,394 through 904,860";
		result = gridMillionLights.isOrderToggle(orderOn);
		assertTrue(result);
	}
	
	@Test
	public void extract_Coordinate() {
		logger.info("------------------extract_Coordinate-------------------------------------");
		String order = "turn on 0,0 through 999,999";
		List<Integer> numerationCorner = gridMillionLights.getNumerationCorners(order);
		assertEquals("Invalid result",(Integer)0, (Integer)numerationCorner.get(0));
		assertEquals("Invalid result",(Integer)0, (Integer)numerationCorner.get(1));
		assertEquals("Invalid result",(Integer)999, (Integer)numerationCorner.get(2));
		assertEquals("Invalid result",(Integer)999, (Integer)numerationCorner.get(3));
		
		order = "turn off 539,243 through 559,965";
		numerationCorner = gridMillionLights.getNumerationCorners(order);
		assertEquals("Invalid result",(Integer)539, (Integer)numerationCorner.get(0));
		assertEquals("Invalid result",(Integer)243, (Integer)numerationCorner.get(1));
		assertEquals("Invalid result",(Integer)559, (Integer)numerationCorner.get(2));
		assertEquals("Invalid result",(Integer)965, (Integer)numerationCorner.get(3));
		
		order = "toggle 831,394 through 904,860";
		numerationCorner = gridMillionLights.getNumerationCorners(order);
		assertEquals("Invalid result",(Integer)831, (Integer)numerationCorner.get(0));
		assertEquals("Invalid result",(Integer)394, (Integer)numerationCorner.get(1));
		assertEquals("Invalid result",(Integer)904, (Integer)numerationCorner.get(2));
		assertEquals("Invalid result",(Integer)860, (Integer)numerationCorner.get(3));
	}
	
	@Test
	public void executeOrderOn9() {
		logger.info("------------------executeOrderOn9-------------------------------------");
		String orderOn = "turn on 0,0 through 2,2";
		gridMillionLights.executeOrder(orderOn);
		assertEquals("Invalid result",(Integer)9, (Integer)gridMillionLights.getlightsTurnedOn());
	}
	
	@Test
	public void executeOrderOn1000000() {
		logger.info("------------------executeOrderOn1000000-------------------------------------");
		String orderOn = "turn on 0,0 through 999,999";
		gridMillionLights.executeOrder(orderOn);
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getlightsTurnedOn());
	}
	
	@Test
	public void executeOrderOn100000() {
		logger.info("------------------executeOrderOn100000-------------------------------------");
		String orderOn = "turn on 0,0 through 999,0";
		gridMillionLights.executeOrder(orderOn);
		assertEquals("Invalid result",(Integer)1000, (Integer)gridMillionLights.getlightsTurnedOn());
		
	}
	
	@Test
	public void executeToogle1000() {
		logger.info("------------------executeToogle1000-------------------------------------");
		String orderToggle = "toggle 0,0 through 999,0";
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getlightsTurnedOff());
		assertEquals("Invalid result",(Integer)0, (Integer)gridMillionLights.getlightsTurnedOn());
		gridMillionLights.executeOrder(orderToggle);
		assertEquals("Invalid result",(Integer)1000, (Integer)gridMillionLights.getlightsTurnedOn());
		gridMillionLights.executeOrder(orderToggle);
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getlightsTurnedOff());
	}
	
	
	@Test
	public void executeOrderOff4() {
		logger.info("------------------executeOrderOff4-------------------------------------");
		String orderOn = "turn on 0,0 through 999,999";
		gridMillionLights.executeOrder(orderOn);
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getlightsTurnedOn());
		String orderOff = "turn off 499,499 through 500,500";
		gridMillionLights.executeOrder(orderOff);
		assertEquals("Invalid result",(Integer)4, (Integer)gridMillionLights.getlightsTurnedOff());
		
	}
	
	@Test
	public void executeOrderExample() {
		logger.info("------------------executeOrderExample-------------------------------------");
		String orderOff1 = "turn off 0,0 through 999,999";
		gridMillionLights.executeOrder(orderOff1);
		assertEquals("Invalid result",(Integer)0, (Integer)gridMillionLights.getlightsTurnedOn());
		String orderOn = "turn on 0,0 through 999,999 ";
		gridMillionLights.executeOrder(orderOn);
		assertEquals("Invalid result",(Integer)1000000, (Integer)gridMillionLights.getlightsTurnedOn());
		String orderToggle = "toggle 0,0 through 999,0";
		gridMillionLights.executeOrder(orderToggle);
		assertEquals("Invalid result",(Integer)999000, (Integer)gridMillionLights.getlightsTurnedOn());
		String orderOff = "turn off 499,499 through 500,500";
		gridMillionLights.executeOrder(orderOff);
		assertEquals("Invalid result",(Integer)998996, (Integer)gridMillionLights.getlightsTurnedOn());
	}
	
	@Test
	public void executeOrderExercise12() {
		logger.info("------------------executeOrderExercise12-------------------------------------");
		
		orderList = gridMillionLights.getOrderList();
		for (String order : orderList) {
			gridMillionLights.executeOrder(order);
		}
		assertEquals("Invalid result",(Integer)377891, (Integer)gridMillionLights.getlightsTurnedOn());
		
		
		
		Integer totalBrightness  = gridMillionLights.getTotalBrightness();
		System.out.println("total brightness :    " + totalBrightness);
		//14110788
	}
	
	
	
	
	
	
	
	
	//14110788
	
}
