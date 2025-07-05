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
		// 주사위 범위 (1 ~ 6) 중 하나가 나오도록 만들기
		int BASE = 1;
		int result = rd.nextInt(6) + BASE;
		System.out.println("Random Dice : " + result);
	}

}
