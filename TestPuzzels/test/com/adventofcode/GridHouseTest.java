package com.adventofcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.adventofcode.day3.GridHouse;
import com.adventofcode.day3.Point;

public class GridHouseTest {
	
	private static final Logger logger = Logger.getLogger(GridHouseTest.class.getName());
	
	GridHouse gridHouse;
	List<String> directionSignsList;
	Set<Point> grid ;
	Point pointInit;
	
	
	@Before
	public void initTets(){
		pointInit = new Point(0,0);
		Set<Point> grid = new HashSet<Point>();
		directionSignsList = new ArrayList<String>();
		gridHouse = new GridHouse(directionSignsList, grid);
	}
	
	@Test
	public void testGetListOperations() {
		logger.info("------------------testGetListOperations-------------------------------------");
		directionSignsList = gridHouse.getDirectionSignsList();
		assertNotNull(directionSignsList);
	}
	
	@Test
	public void testMoveFourHouseinSquare() {
		logger.info("------------------testestMoveFourHouseinSquaretMove-------------------------------------");
		String directions ="^>v<";
		Set<Point> grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)4, (Integer)grid.size());
		directions ="^>v<^";
		grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)4, (Integer)grid.size());
		directions ="^>v<^>";
		grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)4, (Integer)grid.size());
		directions ="^>v<^>v";
		grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)4, (Integer)grid.size());
		directions ="^>v<^>v<";
		grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)4, (Integer)grid.size());
	}
	
	@Test
	public void testMoveTwoHouses() {
		logger.info("------------------testMoveTwoHouses-------------------------------------");
		String directions ="^v^v^v^v^v";
		Set<Point> grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)2, (Integer)grid.size());
		directions ="^>v<^>v<^>v<^>v<";
		grid = gridHouse.move(pointInit,directions);
		assertEquals("Invalid result",(Integer)4, (Integer)grid.size());
		
	}
	
	@Test
	public void testMoveSanta() {
		logger.info("------------------testMoveSanta-------------------------------------");
		List<String> directionSignsList;
		directionSignsList = gridHouse.getDirectionSignsList();
		int result = gridHouse.getResultMoveSanta(pointInit,directionSignsList);
		assertEquals("Invalid result",(Integer)2565, (Integer)result);
	}
	
	@Test
	public void testMoveSantaAndRobot() {
		logger.info("------------------testMoveSantaAndRobot-------------------------------------");
		List<String> directionSignsList;
		directionSignsList = gridHouse.getDirectionSignsList();
		int result = gridHouse.getResultMoveSantaAndRobot(pointInit,directionSignsList);
		assertEquals("Invalid result",(Integer)2639, (Integer)result);
	}
	
	
	
		
}
