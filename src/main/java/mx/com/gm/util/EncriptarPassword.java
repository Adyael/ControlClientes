package mx.com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
	public static void main(String[] args) {
		
		var password = "klqmn805hF_42UA";
		System.out.println("password: "+password);
		System.out.println(" encription: "+ encriptarPassword(password));
		
	}
	
	public static String encriptarPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(password);
	}
}
