package day03;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		System.out.println("nextInt() : " + rd.nextInt());
		System.out.println("nextInt(100) : " + rd.nextInt(100));
		System.out.println("nextFloat() : " + rd.nextFloat());
		System.out.println("nextDouble() : " + rd.nextDouble());
		
		// nextInt(N) : 0 ~ N-1까지 중 하나가 나온다는 것을 이용하여
		// 주사위 범위(1 ~ 6) 중 하나가 나오도록 만들어보십시오(실습).
		int BASE = 1;
		int result = rd.nextInt(6) + BASE;
		System.out.println("Random Dice : " + result);
		
		// Random Alphabet(A-Z)
		// 'A' => 0x41, 65
		char rchar = (char)(rd.nextInt(26) + 65);
		System.out.println("Random Char : " + rchar);
		
		// Random Alphabet(A-Z, a-z)
		// 'A' => 0x41, 65    'a' => 0x61, 97
		// 과연 만들 수 있을까??
		rchar = (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		System.out.println("Random Char : " + rchar);
		
		String resetPassword = "";
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		resetPassword += (char)(rd.nextInt(26) + 65 + 32 * rd.nextInt(2));
		System.out.println("당신의 새로운 패스워드 : " + resetPassword);
	}

}
