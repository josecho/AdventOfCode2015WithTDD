package com.adventofcode.day5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NiceString {

	List<String> stringList;
	
	String secondWord;
	
	
	public int howManyStringAreNice1() {
		int result = 0;
		stringList = getStringList();
		for (String string : stringList) {
			if (containsAtLeastThreeVowels(string) &&
					containsAtLeastOneLetterThatAppearsTwiceTogether(string) &&
				notContainBadStrin(string)){
				result +=1;
			}
		}
		return result;
	}
	
	public int howManyStringAreNice2() {
		int result = 0;
		
		stringList = getStringList();
		for (String word : stringList) {
			if (containsPairOfanyTwoLettersThatApperarsAtLeastTwice2(word) &&
					ifNotcontainsAtLeastThreeVowels(word)	&& containsLetterBetween(word) ){
				result +=1;
			}
		}
		return result;
	}
	
	
	public Boolean ifNotcontainsAtLeastThreeVowels(String word) {
		Boolean result = false;
		Set<Character> letterList = getLettersThatAppearsAtLeastTwice(word);
		for (Character character : letterList) {
			result = lettersApperarsThreetime_continuos(word, character);
			if (result) break;
		}
		return !result;
	}
	
	public Boolean containsLetterBetween(String word) {
		Boolean result = false;
		Set<Character> letterList = getLettersThatAppearsAtLeastTwice(word);
		for (Character character : letterList) {
			result = containsLettersThatAppearsAtLeastTwiceWithLetterBetween(character,word);
			if (result) break;
		}
		return result;
	}
	
	public List<String> getStringList() {
		getStringListInFile();
		return stringList;
	}
	
	
	private void getStringListInFile() {
		List<String> list = null;
		try {
			list = Files.readAllLines(new File("stringList.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		stringList = list;
	}


	public Boolean containsAtLeastThreeVowels(String word) {
		int count=0;
		for(int i=0;i <word.length();i++){
            if((word.charAt(i) == 'a') || 
                (word.charAt(i) == 'e')  ||
                (word.charAt(i) == 'i') || 
                (word.charAt(i) == 'o') ||
                (word.charAt(i) == 'u')) {
            	count+=1;
            }
        }
		if (count>=3){return true;}
		return false;
	}

	public Boolean containsAtLeastOneLetterThatAppearsTwiceTogether(String word) {
		for (int i = 0; i < word.length()-1; i++) {
				  if(word.charAt(i)==word.charAt(i+1)){
			    	  return true;
			  } 
		}
		return false;
	}
	
	public Boolean notContainBadStrin(String word){
		return (notContainTheStringAB(word) &&
		notContainTheStringCD(word) &&
		notContainTheStringPQ(word) &&
		notContainTheStringXY(word));
	}

	public Boolean notContainTheStringAB(String word) {
		String AB = "ab";
		return !word.toLowerCase().contains(AB.toLowerCase());
	}
	
	public Boolean notContainTheStringCD(String word) {
		String CD = "cd";
		return !word.toLowerCase().contains(CD.toLowerCase());
	}
	
	public Boolean notContainTheStringPQ(String word) {
		String PQ = "pq";
		return !word.toLowerCase().contains(PQ.toLowerCase());
	}
	
	public Boolean notContainTheStringXY(String word) {
		String XY = "xy";
		return !word.toLowerCase().contains(XY.toLowerCase());
	}


	public Boolean containsPairOfanyTwoLettersThatApperarsAtLeastTwice(String word) {
		int count=0;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (containsAtLeastOneLetterThatAppearsTwo(letter,word)){
				count +=1;
				secondWord = removeChar(word, letter);
				secondWord = removeChar(secondWord, letter);
				break;
			}
		}
		
		for (int i = 0; i < secondWord.length(); i++) {
			char letter = secondWord.charAt(i);
			if (containsAtLeastOneLetterThatAppearsTwo(letter,secondWord)){
				count +=1;
				break;
			}
		}
		
		if (count >= 2){
			return true;
		}
		return false;
	}
	
	public Boolean containsPairOfanyTwoLettersThatApperarsAtLeastTwice2(String word) {
		int count =0;
		for (int i = 0; i < word.length()-1; i++) {
			Character letter1 = word.charAt(i);
			Character letter2 = word.charAt(i+1);
			String par = letter1.toString()+letter2.toString();
			
			count = word.length() - word.substring(0).replaceAll(par,"").length();
			if (count>= 4) return true;
			
		}
		return false;
	}
	
	public Boolean containsAtLeastOneLetterThatAppearsTwo(char letter,String word) {
		int count =0;
		for (int i = 0; i < word.length(); i++) {
				if(word.charAt(i)==letter){
					count +=1;
					if (count==2){return true;};
			}
		}
		return false;
	}
	
	private static String removeChar(String words, char letter) {
		StringBuffer stringBuffer = new StringBuffer(words);
        for (int i=0; i < stringBuffer.length(); i++){
            char cur = stringBuffer.charAt(i);
            if(cur == letter) {
            	stringBuffer.deleteCharAt(i);
            	break;
            }
        }
        return stringBuffer.toString();
	}


	public Set<Character> getLettersThatAppearsAtLeastTwice(String word) {
		Set<Character> letterList = new HashSet<Character>();
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (containsAtLeastOneLetterThatAppearsTwo(letter,word)){
				letterList.add(letter);
			}
		}
		return letterList;
	}


	public Boolean lettersApperarsThreetime_continuos(String word, Character character) {
		String triple = character.toString()+character.toString()+character.toString();
		if ( word.contains(triple)){
			return true;
		}
		return false;
	}


	public Boolean containsLettersThatAppearsAtLeastTwiceWithLetterBetween(Character character, String word) {
		for (int i = 0; i < word.length()-2; i++) {
			for (int j = i+2; j < word.length(); j+=2) {
				char letter1 = word.charAt(i);
				char letter2 = word.charAt(j);
				if (letter1==letter2) return true;
				break;
			}
		}
		return false;
	}


	

}
