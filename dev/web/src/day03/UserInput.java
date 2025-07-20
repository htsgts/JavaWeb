package day03;

import java.util.Scanner;

import utils.Mu;

public class UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mu.p("User Input Example");
		
		// 1. 실행 시 입력하기
		String workDate = args[0];
		Mu.p("작업일자 : " + workDate);
		Mu.p("작업유형 : " + args[2]);
		
		// 2. Scanner 사용하기
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하십시오 : ");
		String name = sc.next();  // 입력을 문자로 인식하는 것
		System.out.println("앗 당신이 그 유명한 " + name + "님??");
		
		int score1;
		System.out.print("당신의 Java 점수를 입력하세요 : ");
		score1 = sc.nextInt();
		System.out.println("판정결과 : " + ((score1<50)? "관둬라":"계속하십시오"));
		
		double score2;
		System.out.print("당신의 IQ를 입력하세요 : ");
		score2 = sc.nextDouble();
		System.out.println("당신의 지능점수는 " + score2 + " 실화냐?");
		
	}

}
