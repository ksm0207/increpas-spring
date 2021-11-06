package sha256_main;

import java.util.Scanner;

import sha256.SHA256;

public class Main {

	public static void main(String[] args) throws Exception {
	
		SHA256 sha = new SHA256();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("비밀번호를 입력하세요");
		String password = scan.next();
		
		String cryptogram = sha.encrypt(password);
		
		System.out.println("변환 된 값 : " + cryptogram);
		
		System.out.println("eq : " + cryptogram.equals(sha.encrypt(password)));

		
	}
}
