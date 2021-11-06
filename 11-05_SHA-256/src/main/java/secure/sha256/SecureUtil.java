package secure.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SecureUtil {
	
	/*
	public static String getEncrypt(String pwd, String salt) {
		
		System.out.println("(3) 호출");
		
		return getEncrypt(pwd,salt.getBytes());
	}
	*/
	
	// 암호화 구현부분.
	public static String getEncrypt(String pwd , String str) {
		
		String result = "";
		
		byte[] salt = str.getBytes();
		
		System.out.println("(2) Return : "+result);
		
		byte[] a = pwd.getBytes();
		
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0 ; i<byteData.length; i ++)
				sb.append(Integer.toString( (byteData[i] & 0xFF ) + 256, 16).substring(1));
				// sb.append(String.format("",));
			
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	// salt 값을 얻자
	public static String generateSalt() {
	
		Random r = new Random();
		
		byte[] salt = new byte[8];
		r.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		
		for(byte i : salt) {
			
			String str = String.format("%02x", i); // Hex값
			sb.append(str);
			System.out.println("(1)Hex값 : "+sb.toString());
		}
		
		return sb.toString();
		
	}
}
