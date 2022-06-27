package com.grs.util;

import java.util.Random;

public class OTPGenerator {

	public static String GetOTP() {

		String numbers = "0123456789";
		char[] otp = new char[6];

		Random r = new Random();

		for (int i = 0; i < 6; i++) {
			otp[i] = numbers.charAt(r.nextInt(numbers.length()));
		}

		return new String(otp);
	}

}
