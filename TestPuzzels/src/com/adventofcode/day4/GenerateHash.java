package com.adventofcode.day4;

public class GenerateHash {
	
	private static Integer number =0;

	public String getFirstAnswerByFiveCeros(String secretKey) {
		number = 0;
		String hexadecimalHash = null;
		String secretkeyConcatDecimal = concatDecimalNumber(secretKey);
		hexadecimalHash = getHexadecimalHash(hexadecimalHash, secretkeyConcatDecimal);
		while (!hashStartWithAtLeastFiveCeros(hexadecimalHash)) {
			secretkeyConcatDecimal = concatDecimalNumber(secretKey);
			hexadecimalHash = getHexadecimalHash(hexadecimalHash, secretkeyConcatDecimal);
		}
		return number.toString();
	}
	
	public String getSecondAnswerBySixCeros(String secretKey) {
		number = 0;
		String hexadecimalHash = null;
		String secretkeyConcatDecimal = concatDecimalNumber(secretKey);
		hexadecimalHash = getHexadecimalHash(hexadecimalHash, secretkeyConcatDecimal);
		while (!hashStartWithAtLeastSixCeros(hexadecimalHash)) {
			secretkeyConcatDecimal = concatDecimalNumber(secretKey);
			hexadecimalHash = getHexadecimalHash(hexadecimalHash, secretkeyConcatDecimal);
		}
		return number.toString();
	}

	private String getHexadecimalHash(String hexadecimalHash, String secretkeyConcatDecimal) {
		try {
			hexadecimalHash = HashingUtility.MD5_encode(secretkeyConcatDecimal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hexadecimalHash;
	}

	private String concatDecimalNumber(String secretKey) {
		number += 1;
		String secretkeyConcatDecimal = secretKey.concat(number.toString());
		return secretkeyConcatDecimal;
	}

	public Boolean hashStartWithAtLeastFiveCeros(String hexadecimalHash) {
		String result = hexadecimalHash.substring(0, 5);
		if (result.equals("00000")){
			return true;
		}
		return false;
	}
	
	public Boolean hashStartWithAtLeastSixCeros(String hexadecimalHash) {
		String result = hexadecimalHash.substring(0, 6);
		if (result.equals("000000")){
			return true;
		}
		return false;
	}

}
