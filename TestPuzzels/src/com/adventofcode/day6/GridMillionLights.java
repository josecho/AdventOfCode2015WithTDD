package com.adventofcode.day6;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class GridMillionLights {
	
	Ligth[][] grid;
	List<String> orderList;
	public static Integer res;
	
	
	

	public List<String> getOrderList() {
		getOrderListInFile();
		return orderList;
	}	
	
	private void getOrderListInFile() {
		List<String> list = null;
		try {
			list = Files.readAllLines(new File("ligthers1000.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		orderList = list;
	}

	public GridMillionLights() {
		super();
		grid = new Ligth[1000][1000];
		for(int i = 0; i < 1000; i++){
			for(int j = 0; j < 1000; j++){
				Ligth initLigth = new Ligth(0);
				initLigth.setTurn(false);
	            grid[i][j] = initLigth;         
	        }
		}
	}

	public int getSize() {
		int count = 0;
		for(int row = 0; row < grid.length; row++){
			  for(int element = 0; element < grid[row].length; element++){
				  count +=1;
			  }
		}
		return count;
	}
	
	public Integer getTotalBrightness () {
		int count = 0;
		for(int row = 0; row < grid.length; row++){
			  for(int element = 0; element < grid[row].length; element++){
				  Ligth ligthElement =  grid[row][element];
				  count += ligthElement.getBrightness();
			  }
		}
		return count;
	}

	private boolean ligthOff(Ligth ligthElement) {
		return !ligthOn(ligthElement);
	}

	public Integer getlightsTurnedOn() {
		int count = 0;
		for(int row = 0; row < grid.length; row++){
			  for(int element = 0; element < grid[row].length; element++){
				  Ligth ligthElement =  grid[row][element];
				  if (ligthOn(ligthElement)){
					  count +=1;
				  }
			  }
		}
		return count;
	}
	
	public Integer getlightsTurnedOff() {
		int count = 0;
		for(int row = 0; row < grid.length; row++){
			  for(int element = 0; element < grid[row].length; element++){
				  Ligth ligthElement =  grid[row][element];
				  if (ligthOff(ligthElement)){
					  
					  count +=1;
				  }
			  }
		}
		return count;
	}

	private boolean ligthOn(Ligth ligthElement) {
		return ligthElement.isTurn();
	}

	public Boolean isOrderOn(String orderOn) {
		return orderOn.contains("turn on");
	}

	public Boolean isOrderOff(String orderOn) {
		return orderOn.contains("turn off");
	}

	public Boolean isOrderToggle(String orderOn) {
		return orderOn.contains("toggle");
	}

	public List<Integer> getNumerationCorners(String order) {
		List<String> fourStrings = new ArrayList<String>();
		for(String token : order.split(" ")){
	       fourStrings.add(token) ;
		}
		List<String> twoStrings = new ArrayList<String>();
		
		if (isOrderToggle(order)){
			twoStrings.add(fourStrings.get(1));
			twoStrings.add(fourStrings.get(3));
		}else{
			twoStrings.add(fourStrings.get(2));
			twoStrings.add(fourStrings.get(4));	
		}
		
		List<Integer> fourIntegers = new ArrayList<Integer>();
		String firstString = twoStrings.get(0);
		for(String token : firstString.split(",")){
			fourIntegers.add(Integer.parseInt(token)); 
		}
		String secondString = twoStrings.get(1);
		for(String token : secondString.split(",")){
			fourIntegers.add(Integer.parseInt(token)); 
		}
		return fourIntegers;
	}

	public void executeOrder(String order) {
		List<Integer> numeratioCorners = getNumerationCorners(order);
		Integer rowLow = numeratioCorners.get(0);
		Integer elementLow = numeratioCorners.get(1);
		Integer rowHigh = numeratioCorners.get(2);
		Integer elementHigh= numeratioCorners.get(3);
		
		for(int row = rowLow; row < rowHigh+1; row++){
			  for(int element = elementLow; element < elementHigh+1; element++){
				  Ligth ligthElement =  grid[row][element];
				  if (isOrderOn(order)){
					  int brillo = ligthElement.getBrightness();
					  brillo +=1;
					  ligthElement.setBrightness(brillo);
					  ligthElement.setTurn(true);
				  }
				  if (isOrderOff(order)){
					  int brillo = ligthElement.getBrightness();
					  if ( brillo>0) brillo -= 1;
					  ligthElement.setBrightness(brillo);
					  ligthElement.setTurn(false);
				  }
				  if (isOrderToggle(order)){
					  int brillo = ligthElement.getBrightness();
					  brillo +=2;
					  ligthElement.setBrightness(brillo);
					  ligthElement.toggle();
				  }
				  grid[row][element]=ligthElement;
			  }
		}
	}
	
	

}
