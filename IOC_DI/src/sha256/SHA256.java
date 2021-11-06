package sha256;

import java.security.MessageDigest;

public class SHA256 {
	
	public String encrypt(String text) throws Exception {
		
		System.out.println("호출");
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());
		
		return byteToHex(md.digest());
		
	}

	private String byteToHex(byte[] digest) {
		System.out.println("호출 2");
		StringBuilder sb = new StringBuilder();
		
		for (byte b : digest ) {
			
			sb.append(String.format("%02x",b));
			System.out.print("Hex : " + sb.toString());
		}
		
		
		return sb.toString();
	}
}
