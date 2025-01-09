package com.ram.foodie.Security;

import com.ram.foodie.secret.Secret;

public class Encrypt {

		public static String encrypt(String str) {
			String newStr ="";
			for(int i=0;i<str.length();i++) {
				newStr = newStr+(char)(str.charAt(i)+Secret.getKey());
			}
			return newStr;
		}
}	
