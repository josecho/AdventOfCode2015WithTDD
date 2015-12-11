package com.adventofcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public class OperationsUtil {
	
	private static final Logger logger = Logger.getLogger(WrappingPaperTest.class.getName());
	
	
	
	public static void fromListStringToListInteger(ArrayList<String> myList, ArrayList<Integer> result) {
		for(String stringValue : myList) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
               //System.out.println("Could not parse " + nfe);
            	logger.warning("NumberFormat: Parsing failed! "+ stringValue + " can not be an integer");
            } 
        }
	}
	
	public static int[] fromListIntegerToArrayInteger(ArrayList<Integer> myList) {
		int[] result = new int[ myList.size() ];
		for(Integer integerValue : myList) {
		    int i = 0;
		    for( Iterator<Integer> it = myList.iterator(); 
		         it.hasNext(); 
		         result[i++] = it.next() );
        }
		return result;
	}
	

	public static char[] stringToVectorChar(String directions) {
		char[] result = directions.toCharArray();
		return result;
	}

}
