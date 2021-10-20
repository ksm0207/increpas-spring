package 알고리즘;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main5596 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int S = 0;
		int T = 0;
		int minguk = 0;
		int mansae = 0;
		
		for(int i=0; i<4; i ++) {
			
			minguk = scan.nextInt();
			S += minguk;
		}
		
		for(int i=0; i<4; i++) {
			mansae = scan.nextInt();
			T += mansae;
		}
//		System.out.println("S 민국 : "+S);
//		System.out.println("T 만세 : "+T);
		
		if(S >= T)
			System.out.println(S);
		
		if(S < T)
			System.out.println(T);
		
		
	}
}
