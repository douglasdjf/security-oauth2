package br.com.securityoauth2.securityoauth2.security.util;

import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

	public static void main(String[] args) {
	
			/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(encoder.encode("admin")); // 
			System.out.println(encoder.encode("m0b1l30"));
		    System.out.println(encoder.encode("@ngul@r0"));

		     System.out.println("TESTE  "+ encoder.matches("admin", "admin"));*/


		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "yawinpassword";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println();
		System.out.println("Password is         : " + password);
		System.out.println("Encoded Password is : " + encodedPassword);
		System.out.println();

		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

		password = "yawin";
		isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "           isPasswordMatch    : " + isPasswordMatch);





	}

}
