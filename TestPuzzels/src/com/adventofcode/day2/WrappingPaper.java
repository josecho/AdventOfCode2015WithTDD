package com.adventofcode.day2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.adventofcode.OperationsUtil;

public class WrappingPaper {
	
	
	List<String> operationsList;

	public List<String> getOperationsList() {
		getOperationsInFile();
		return operationsList;
	}

	private void getOperationsInFile() {
		List<String> list = null;
		try {
			list = Files.readAllLines(new File("operacions.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		operationsList = list;
	}
	

	public Integer calculateSurfaceArea(String dimension) {
		int[] operators = splitDimensionInOperands(dimension);
		int result = 2*operators[0]*operators[1] + 2*operators[1]*operators[2] +
				2*operators[0]*operators[2];
		return result;
	}

	public int calculateAreaSmallestSide(String dimension) {
		int[] operators = splitDimensionInOperands(dimension);
		Arrays.sort(operators);
		return operators[0] * operators[1];
	}
	

	public int calculateAreaWrappingPaperOnePackage(String dimension) {
		int resultSurfaceArea = calculateSurfaceArea(dimension);
		int resultAreaSmallestSide = calculateAreaSmallestSide(dimension);
		return resultSurfaceArea + resultAreaSmallestSide;
	}

	public int getAreaWrappingPaperAllPackage(List<String> opetationsList) {
		int result = 0;
		for (String dimension : opetationsList) {
			result += calculateAreaWrappingPaperOnePackage(dimension);
		}
		return result;
	}

	public int getLengthRibbonAllPackage(List<String> opetationsList) {
		int result = 0;
		for (String dimension : opetationsList) {
			result += calculateShortestDistanceAroundItsSidesOnePacket(dimension);
		}
		return result;
	}
	
	public int calculateShortestDistanceAroundItsSidesOnePacket(String dimension) {
		int[] operators = splitDimensionInOperands(dimension);
		return calculateShortestPerimeterItsSidesOnePacket(dimension) + (operators[0]*operators[1]*operators[2]);
		
	}
	
	public int calculateShortestPerimeterItsSidesOnePacket(String dimension) {
		int[] operators = splitDimensionInOperands(dimension);
		Arrays.sort(operators);
		return (2* operators[0] + 2* operators[1]);
	}
	
	public int[] splitDimensionInOperands(String dimension) {
		ArrayList<String> myList = new ArrayList<>();
		Collections.addAll(myList, dimension.split("x"));
		ArrayList<Integer> result = new ArrayList<Integer>();
		OperationsUtil.fromListStringToListInteger(myList, result); 
		return OperationsUtil.fromListIntegerToArrayInteger(result);
		
	}
	
}
