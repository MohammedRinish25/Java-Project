/**
 * 
 */
package com.bikerental.util;

/**
 * @author MohammedRinishA
 *
 */
public class PasswordGenerator {
	
	public static String randomPassword() {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(8);

		for (int i = 0; i < 8; i++) {

			int index
			= (int)(AlphaNumericString.length()
					* Math.random());

			sb.append(AlphaNumericString
					.charAt(index));
			
		}

		return sb.toString();

	}

}
