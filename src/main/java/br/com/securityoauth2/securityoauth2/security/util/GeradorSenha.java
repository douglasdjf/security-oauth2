package br.com.securityoauth2.securityoauth2.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

	public static void main(String[] args) {
	
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(encoder.encode("admin")); // 
			System.out.println(encoder.encode("m0b1l30"));
		    System.out.println(encoder.encode("@ngul@r0"));

	}

}
