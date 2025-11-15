package day04;

import java.util.Random;

import utils.Mu;

public class ColorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// AA라는 글자를 8색으로 나타내시오.
		// for문을 사용하여 AAAAAAAAAAAAAAAA
		// 일반 8색을 구현하시오.
		for(int i=30; i<38; i++) {
			System.out.print("\033[" + i + "m" + "AA" + "\033[0m");
		}
		Mu.p("");
		for(int i=90; i<98; i++) {
			System.out.print("\033[" + i + "m" + "AA" + "\033[0m");
		}
		Mu.p("");
		for(int i=40; i<48; i++) {
			System.out.print("\033[" + i + "m" + "  " + "\033[0m");
		}
		Mu.p("");
		for(int i=100; i<108; i++) {
			System.out.print("\033[" + i + "m" + "  " + "\033[0m");
		}
		Mu.p("");
		
		// 확장 256색을 구현하시오. (바탕색, 글자는 공백1글자로)
		for(int i=0; i<256; i++) {
			System.out.print("\033[48;5;" + i + "m" + " " + "\033[0m");
		}
		Mu.p("");
		
		// True Color
		// RED, GREEN, BLUE 각각을 0~255중 하나로 랜덤으로 뽑는다.
		// 픽셀로 나타낸다. 이 과정을 256번 반복한다.
		Random rd = new Random();
		int r, g, b;
		for(int i=0; i<256; i++) {
			r = rd.nextInt(256);
			g = rd.nextInt(256);
			b = rd.nextInt(256);
			System.out.print("\033[48;2;" + r + ";" + g + ";" + b + "m" + " " + "\033[0m");
		}
		
		System.out.println("");
		
		for(int i=0; i<256; i++) {
			r = rd.nextInt(256);
			g = r;
			b = r;
			System.out.print("\033[48;2;" + r + ";" + g + ";" + b + "m" + " " + "\033[0m");
		}
		
	}

}
