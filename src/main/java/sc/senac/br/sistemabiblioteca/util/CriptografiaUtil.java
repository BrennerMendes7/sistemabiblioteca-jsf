package sc.senac.br.sistemabiblioteca.util;

import org.apache.commons.codec.digest.Crypt;

public class CriptografiaUtil {
	
	private static final String SALT = "30d0abe2d3bf7682ff799a0513598d6a";
	
	public static String criptografar(String texto) {
		return Crypt.crypt(texto, SALT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
