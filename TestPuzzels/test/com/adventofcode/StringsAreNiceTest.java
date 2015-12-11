package com.adventofcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.adventofcode.day5.NiceString;
import com.sun.xml.internal.ws.policy.AssertionSet;

public class StringsAreNiceTest {

	private static final Logger logger = Logger.getLogger(GridHouseTest.class.getName());
	
	List<String> stringList;
	NiceString niceString;
	
	@Before
	public void initTets(){
		niceString = new NiceString();
		stringList = new ArrayList<String>();
	}
		
	@Test
	@Ignore
	public void testGetStrings() {
		logger.info("------------------Get direction signs-------------------------------------");
		stringList = niceString.getStringList();
		assertNotNull(stringList);
	}
	
	@Test
	@Ignore
	public void testcontainsAtLeastThreeVowels() {
		logger.info("------------------testcontainsAtLeastThreeVowels------------------------");
		String word = "aei";
		Boolean result = niceString.containsAtLeastThreeVowels(word);
		assertTrue(result);
		word = "xazegov";
		result = niceString.containsAtLeastThreeVowels(word);
		assertTrue(result);
		word = "aeiouaeiouaeiou";
		result = niceString.containsAtLeastThreeVowels(word);
		assertTrue(result);
		word = "ou";
		result = niceString.containsAtLeastThreeVowels(word);
		assertFalse(result);
		word = "ou";
		result = niceString.containsAtLeastThreeVowels(word);
		assertFalse(result);
	}
	
	@Test
	@Ignore
	public void testAtLeastOneLetterThatAppearsTwice() {
		logger.info("------------------testcontainsAtLeastThreeVowels------------------------");
		String word = "xx";
		Boolean result = niceString.containsAtLeastOneLetterThatAppearsTwiceTogether(word);
		assertTrue(result);
		word = "abcdde";
		result = niceString.containsAtLeastOneLetterThatAppearsTwiceTogether(word);
		assertTrue(result);
		word = "aabbccdd";
		result = niceString.containsAtLeastOneLetterThatAppearsTwiceTogether(word);
		assertTrue(result);
		word = "ou";
		result = niceString.containsAtLeastOneLetterThatAppearsTwiceTogether(word);
		assertFalse(result);
		word = "utyiaeo";
		result = niceString.containsAtLeastOneLetterThatAppearsTwiceTogether(word);
		assertFalse(result);
	}
	
	@Test
	@Ignore
	public void testNotContainTheStringAB() {
		logger.info("------------------testNotContainTheStringAB------------------------");
		String word = "ab";
		Boolean result = niceString.notContainTheStringAB(word);
		assertFalse(result);
		word = "acabdde";
		result = niceString.notContainTheStringAB(word);
		assertFalse(result);
		word = "babccdd";
		result = niceString.notContainTheStringAB(word);
		assertFalse(result);
		word = "ouavbgb";
		result = niceString.notContainTheStringAB(word);
		assertTrue(result);
		word = "ubbatyiaeoakb";
		result = niceString.notContainTheStringAB(word);
		assertTrue(result);
	}
	
	@Test
	@Ignore
	public void testNotContainTheStringCD() {
		logger.info("------------------testNotContainTheStringCD------------------------");
		String word = "cdb";
		Boolean result = niceString.notContainTheStringCD(word);
		assertFalse(result);
		word = "acabcddde";
		result = niceString.notContainTheStringCD(word);
		assertFalse(result);
		word = "bcdabccdd";
		result = niceString.notContainTheStringCD(word);
		assertFalse(result);
		word = "ouavbgb";
		result = niceString.notContainTheStringCD(word);
		assertTrue(result);
		word = "ubbatyiaeoakb";
		result = niceString.notContainTheStringCD(word);
		assertTrue(result);
	}
	
	@Test
	@Ignore
	public void testNotContainTheStringPQ() {
		logger.info("------------------testNotContainTheStringCD------------------------");
		String word = "cpqdb";
		Boolean result = niceString.notContainTheStringPQ(word);
		assertFalse(result);
		word = "acabcpqddde";
		result = niceString.notContainTheStringPQ(word);
		assertFalse(result);
		word = "bcpqdabccdd";
		result = niceString.notContainTheStringPQ(word);
		assertFalse(result);
		word = "ouavbgb";
		result = niceString.notContainTheStringPQ(word);
		assertTrue(result);
		word = "ubbatyiaeoakb";
		result = niceString.notContainTheStringPQ(word);
		assertTrue(result);
	}
	
	@Test
	@Ignore
	public void testNotContainTheStringXY() {
		logger.info("------------------NotContainTheStringXY------------------------");
		String word = "cpqxydb";
		Boolean result = niceString.notContainTheStringXY(word);
		assertFalse(result);
		word = "acabcxypqddde";
		result = niceString.notContainTheStringXY(word);
		assertFalse(result);
		word = "bcpqdabccddxy";
		result = niceString.notContainTheStringXY(word);
		assertFalse(result);
		word = "oyuavbxgb";
		result = niceString.notContainTheStringXY(word);
		assertTrue(result);
		word = "ubyatyiaeoxakb";
		result = niceString.notContainTheStringXY(word);
		assertTrue(result);
	}
	
	@Test
	@Ignore
	public void testHowManyStringAreNice1() {
		logger.info("------------------testHowManyStringAreNice------------------------");
		int result = niceString.howManyStringAreNice1();
		System.out.println("REsultado total :" + result);
		Integer expected=258;
		assertEquals("Invalid result",expected, (Integer)result);
	}
	
	//Second exercicy
	
	@Test
	@Ignore
	public void  pair_Of_any_Two_Letters_That_Apperars_At_Least_Twice() {
		logger.info("------------------pairOfanyTwoLettersThatApperarsAtLeastTwice----------------------");
		String word = "qjhvhtzxzqqjkmpb";
		Boolean result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice(word);
		assertTrue(result);
		word = "xxyxx";
		result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice(word);
		assertTrue(result);
		word = "xxyx";
		result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice(word);
		assertFalse(result);
		word = "yxyvbnmr";
		result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice(word);
		assertFalse(result);
	}
	
	@Test
	public void  pair_Of_any_Two_Letters_That_Apperars_At_Least_Twice2() {
		logger.info("------------------pairOfanyTwoLettersThatApperarsAtLeastTwice----------------------");
		String word = "qjhvhtzxzqqjkmpb";
		Boolean result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice2(word);
		assertTrue(result);
		word = "xxyxx";
		result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice2(word);
		assertTrue(result);
		word = "xxyx";
		result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice2(word);
		assertFalse(result);
		word = "yxyvbnmry";
		result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice2(word);
		assertFalse(result);
	}
	
	@Test
	@Ignore
	public void  letters_That_Apperars_AtLeast_Twice() {
		logger.info("------------------letters_That_Apperars_AtLeast_Twice----------------------");
		String word = "qjhvhtzxzqqjkmpb";
		Set<Character> letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		assertEquals("Invalid result",(Integer)4, (Integer)letterList.size());
		System.out.println(letterList);
		word = "aabbccdfghjkll";
		letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		assertEquals("Invalid result",(Integer)4, (Integer)letterList.size());
	}
	
	@Test
	@Ignore
	public void  letters_Apperars_Three_times_continuos() {
		logger.info("------------------letters_Apperars_Three_times_continuos----------------------");
		
		String word = "qqqhtzxz";
		Set<Character> letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		Boolean result = false;
		for (Character character : letterList) {
			result = niceString.lettersApperarsThreetime_continuos(word, character);
			if (result) break;
		}
		assertTrue(result); 
		
		word = "tzaaaaxzaaaa";
		letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		result = false;
		for (Character character : letterList) {
			result = niceString.lettersApperarsThreetime_continuos(word, character);
			if (result) break;
		}
		assertTrue(result); 
		
		word = "qqhtzxzqqjkmpb";
		letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		result = false;
		for (Character character : letterList) {
			result = niceString.lettersApperarsThreetime_continuos(word, character);
			if (result) break;
		}
		assertFalse(result); 
		
		word = "qqzqqjpp";
		letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		result = false;
		for (Character character : letterList) {
			result = niceString.lettersApperarsThreetime_continuos(word, character);
			if (result) break;
		}
		assertFalse(result); 
		
	}
	
	@Test
	@Ignore
	public void contains_at_least_one_letter_which_repeats_with_exactly_one_letter_between_them() {
		logger.info("-----contains_at_least_one_letter_which_repeats_with_exactly_one_letter_between_them--------");
		Boolean result = false;
		String word = "qqcqhtzxz";
		Set<Character> letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		for (Character character : letterList) {
			result = niceString.containsLettersThatAppearsAtLeastTwiceWithLetterBetween(character,word);
			if (result) break;
		}
		assertTrue(result); 
		
		word = "qqqhzzz";
		letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		for (Character character : letterList) {
			result = niceString.containsLettersThatAppearsAtLeastTwiceWithLetterBetween(character,word);
			if (result) break;
		}
		assertTrue(result); 
		
		word = "qqcvqhtzz";
		letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		for (Character character : letterList) {
			result = niceString.containsLettersThatAppearsAtLeastTwiceWithLetterBetween(character,word);
			if (result) break;
		}
		assertFalse(result); 
	}
	
	

	@Test
	@Ignore
	public void checkAllrules() {
		logger.info("------------------testHowManyStringAreNice------------------------");
		String word = "qjhvhtzxzqqjkmpb";
		Boolean result = niceString.containsPairOfanyTwoLettersThatApperarsAtLeastTwice(word);
		assertTrue(result);
		
		Set<Character> letterList = niceString.getLettersThatAppearsAtLeastTwice(word);
		assertEquals("Invalid result",(Integer)4, (Integer)letterList.size());
		System.out.println(letterList);
		
		result = false;
		for (Character character : letterList) {
			result = niceString.lettersApperarsThreetime_continuos(word, character);
			if (result) break;
		}
		assertFalse(result); 
		
		for (Character character : letterList) {
			result = niceString.containsLettersThatAppearsAtLeastTwiceWithLetterBetween(character,word);
			if (result) break;
		}
		assertTrue(result); 
	}
	
	
	
	
	
	
	@Test
	public void testHowManyStringAreNice2() {
		logger.info("------------------testHowManyStringAreNice2()   **************------------------------");
		int result = niceString.howManyStringAreNice2();
		System.out.println("REsultado ******total :" + result);
		/*Integer expected=258;
		assertEquals("Invalid result",expected, (Integer)result);*/
	}
	
	
	
	//384
	
	
	
	
	
	
} 


