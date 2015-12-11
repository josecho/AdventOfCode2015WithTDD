package com.adventofcode.day3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

import com.adventofcode.OperationsUtil;

public class GridHouse {
	
	List<String> directionSignsList;
	
	Set<Point> grid ;
	
	public GridHouse(List<String> directionSignsList, Set<Point> grid) {
		super();
		this.directionSignsList = directionSignsList;
		this.grid = grid;
	}

	public Set<Point> getGrid() {
		return grid;
	}

	public List<String> getDirectionSignsList() {
		getDirectionSignsListInFile();
		return directionSignsList;
	}

	private void getDirectionSignsListInFile() {
		List<String> list = null;
		try {
			list = Files.readAllLines(new File("directionSigns.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		directionSignsList = list;
	}

	public Set<Point> move(Point pointInit, String directions) {
		char[]  directionList = OperationsUtil.stringToVectorChar(directions);
		int x = pointInit.getX();
		int y = pointInit.getY();
		for (char sign : directionList) {
			Point point = new Point(x,y);
			if (">".contains(String.valueOf(sign))){
				x = moveRigth(x, point);
			}
			if ("v".contains(String.valueOf(sign))){
				y = moveDown(y, point);
			}
			if ("<".contains(String.valueOf(sign))){
				x = moveLeft(x, point);
			}
			if ("^".contains(String.valueOf(sign))){
				y = moveUp(y, point);
			}
		}
		return getGrid();
	}
	
	public Set<Point> moveSanta(Point pointInit,List<String> directions) {
		char[]  directionList = OperationsUtil.stringToVectorChar(directions.get(0));
		int x = pointInit.getX();
		int y = pointInit.getY();
		for (char sign : directionList) {
			Point point = new Point(x,y);
			if (">".contains(String.valueOf(sign))){
				x = moveRigth(x, point);
			}
			if ("v".contains(String.valueOf(sign))){
				y = moveDown(y, point);
			}
			if ("<".contains(String.valueOf(sign))){
				x = moveLeft(x, point);
			}
			if ("^".contains(String.valueOf(sign))){
				y = moveUp(y, point);
			}
		}
		return getGrid();
	}
	public int getResultMoveSantaAndRobot(Point pointInit, List<String> directionSignsList) {
		Set<Point> grid = moveSantaAndRobot(pointInit, directionSignsList);
		int result = grid.size();
		if (!grid.contains(pointInit)){
			result += 1;
		}
		return result;
	}
	
	public int getResultMoveSanta(Point pointInit, List<String> directionSignsList) {
		Set<Point> grid = moveSanta(pointInit, directionSignsList);
		int result = grid.size();
		if (!grid.contains(pointInit)){
			result += 1;
		}
		return result;
	}
	
	public Set<Point> moveSantaAndRobot(Point pointInit,List<String> directions) {
		char[]  directionList = OperationsUtil.stringToVectorChar(directions.get(0));
		fromInitPointStarSanta(pointInit, directionList);
		fromInitPointStartRobot(pointInit, directionList);
		return getGrid();
	}

	private void fromInitPointStarSanta(Point pointInit, char[] directionList) {
		int x = pointInit.getX();
		int y = pointInit.getY();
		for(int i=0; i <directionList.length; i+=2){ 
			Point point = new Point(x,y);
			if (">".contains(String.valueOf(directionList[i]))){
				x = moveRigth(x, point);
			}
			if ("v".contains(String.valueOf(directionList[i]))){
				y = moveDown(y, point);
			}
			if ("<".contains(String.valueOf(directionList[i]))){
				x = moveLeft(x, point);
			}
			if ("^".contains(String.valueOf(directionList[i]))){
				y = moveUp(y, point);
			}
		}
	}
	
	private void fromInitPointStartRobot(Point pointInit, char[] directionList) {
		int x = pointInit.getX();
		int y = pointInit.getY();
		for(int i=1; i <directionList.length; i+=2){ 
			Point point = new Point(x,y);
			if (">".contains(String.valueOf(directionList[i]))){
				x = moveRigth(x, point);
			}
			if ("v".contains(String.valueOf(directionList[i]))){
				y = moveDown(y, point);
			}
			if ("<".contains(String.valueOf(directionList[i]))){
				x = moveLeft(x, point);
			}
			if ("^".contains(String.valueOf(directionList[i]))){
				y = moveUp(y, point);
			}
		}
	}
	
	private int moveUp(int y, Point point) {
		y +=1;
		point.setY(y);
		grid.add(point);
		return y;
	}

	private int moveLeft(int x, Point point) {
		x -=1;
		point.setX(x);
		grid.add(point);
		return x;
	}

	private int moveDown(int y, Point point) {
		y -=1;
		point.setY(y);
		grid.add(point);
		return y;
	}

	private int moveRigth(int x, Point point) {
		x +=1;
		point.setX(x);
		grid.add(point);
		return x;
	}

	

}
