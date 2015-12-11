package com.adventofcode;

import static org.junit.Assert.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.adventofcode.day4.HashingUtility;
import com.adventofcode.day4.GenerateHash;

public class Md5HashKeyTest {
	
	private static final Logger logger = Logger.getLogger(Md5HashKeyTest.class.getName());
	
	GenerateHash generateHash;
	
	@Before
	public void initTets(){
		generateHash = new GenerateHash();
	}
	
	@Test
	@Ignore
	public void testGetHahsInHexadecimal() {
		logger.info("------------------testGetHaxInHexadecimal-------------------------------------");
		String secretKey = "abcdef609043";
		String expected = "000001dbbfa3a5c83a2d506429c7b00e";
		String result = null;
		try {
			result = HashingUtility.MD5_encode(secretKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		assertEquals(expected, result);
		
	}
	
	@Test
	@Ignore
	public void testHashStartWithAtLeastFiveCeros() {
		logger.info("------------------testGetHaxInHexadecimalx-------------------------------------");
		String secretKey = "abcdef";
		String hexadecimalHash = null;
		try {
			hexadecimalHash = HashingUtility.MD5_encode(secretKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Boolean result = generateHash.hashStartWithAtLeastFiveCeros(hexadecimalHash);
		assertEquals(Boolean.class, result.getClass());
	}
	
	@Test
	public void testgetFirstAnswerByFiveCeros1() {
		logger.info("------------------testgetFirstAnswerByFiveCeros1-------------------------------------");
		String secretKey = "abcdef";
		String expected="609043";
		String result = null;
		System.out.println(secretKey);
		System.out.println("Expected: " + expected);
		result = generateHash.getFirstAnswerByFiveCeros(secretKey);
		System.out.println("Result: " +result);
		assertEquals("Invalid result",expected, result);
		
		 
	}
	
	@Test
	public void testgetFirstAnswerByFiveCeros2() {
		logger.info("------------------testgetFirstAnswerByFiveCeros2-------------------------------------");
		String secretKey = "pqrstuv";
		String expected="1048970";
		String result = null;
		System.out.println(secretKey);
		System.out.println("Expected: " + expected);
		result = generateHash.getFirstAnswerByFiveCeros(secretKey);
		System.out.println("Result: " +result);
		assertEquals("Invalid result",expected, result);
	}
	
	@Test
	public void testgetFirstAnswerByFiveCeros3() {
		logger.info("------------------testgetFirstAnswerByFiveCeros3-------------------------------------");
		String secretKey = "iwrupvqb";
		String expected="346386";
		String result = null;
		System.out.println(secretKey);
		System.out.println("Expected: " + expected);
		result = generateHash.getFirstAnswerByFiveCeros(secretKey);
		System.out.println("Result: " +result);
		assertEquals("Invalid result",expected, result);
	}
	
	@Test
	//@Ignore
	public void testGetSecondAnswerBySixCeros() {
		logger.info("------------------testGetSecondAnswerBySixCeros-------------------------------------");
		String secretKey = "iwrupvqb";
		String expected="9958218";
		String result = null;
		System.out.println(secretKey);
		System.out.println("Expected: " + expected);
		result = generateHash.getSecondAnswerBySixCeros(secretKey);
		System.out.println("Result: " +result);
		assertEquals("Invalid result",expected, result);
	}
	
	
	
	
}
