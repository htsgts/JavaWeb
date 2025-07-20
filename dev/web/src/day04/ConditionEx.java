package day04;

import java.util.Random;

import utils.Mu;

public class ConditionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mu.p(Mu.RED + "IF Example" + Mu.END);
		Random rd = new Random();
		int num = rd.nextInt(151);  // 0 ~ 150
		Mu.p("Current Num : " + num); 
		
		if(num > 100) {  // 문장이 단 한 줄일 경우 중괄호 생략 가능
			Mu.p(Mu.RED + "매우 큰 수군요" + Mu.END);
		}
		else if(num > 50) {
			Mu.p(Mu.RED + "적당히 큰 수군요" + Mu.END);
		}
		else {
			Mu.p("num은 허접입니다.");
		}
		
		// nested
		int eng = rd.nextInt(101);
		int math = rd.nextInt(101);
		
		// 영어와 수학 점수가 모두 60점 이상이면 Pass, 아니면 Fail을 출력하시오.
		// 영어 : **점, 수학 : **점, Pass 또는 Fail
		
		// 방법1
		if(eng >= 60)
			if(math >= 60)
				Mu.p("영어 : " + eng + "점, 수학 : " + math + "점, Pass");
			else
				Mu.p("영어 : " + eng + "점, 수학 : " + math + "점, Fail");
		else
			Mu.p("영어 : " + eng + "점, 수학 : " + math + "점, Fail");
		
		// 방법2 : 공통부분 분리
		String pf = "";
		
		if(eng >= 60)
			if(math >= 60)
				pf = "Pass";
			else
				pf = "Fail";
		else
			pf = "Fail";
		
		Mu.p("영어 : " + eng + "점, 수학 : " + math + "점, " + pf);
		
		// 방법3 : 하나를 지정하고 아닐 때만 변경
		pf = "Fail";
		
		if(eng >= 60)
			if(math >= 60)
				pf = "Pass";
		
		Mu.p("영어 : " + eng + "점, 수학 : " + math + "점, " + pf);
		
		// 방법4 : 관계 연산자의 활용
		pf = "Fail";
		
		if(eng >= 60 && math >= 60) pf = "Pass";
			
		Mu.p("영어 : " + eng + "점, 수학 : " + math + "점, " + pf);
		
		Mu.p("");
		Mu.p(Mu.RED + "Switch Example" + Mu.END);
		
		int i = rd.nextInt(3);  // 0, 1, 2 중 하나
		
		switch(i) {
			case 0:
				Mu.p("아 0이시네요 꽝입니다.");
				break;
			case 1:
				Mu.p("아 1이시네요 이것도 꽝입니다.");
				break;
			case 2:
				Mu.p(Mu.RED + "드디어 당첨!!!! 상금 10원" + Mu.END);
				break;
			default:
				Mu.p("엄청난 버그 발생.... 시스템 오류");
		}
		
		// 의도적으로 break를 빼는 경우
		// 아래 단계의 작업이 상위 작업을 반드시 거쳐야 되는 경우
		// 작업 간 포함 개념이 있을 때 제한적으로 유용
		
		int workProcess = rd.nextInt(4);
		Mu.p("앞으로의 작업 단계");
		
		switch(workProcess) {
			case 0:
				Mu.p("Step1 : 작업준비");
			case 1:
				Mu.p("Step2 : 개발준비");
			case 2:
				Mu.p("Step3 : 개발완료");
			case 3:
				Mu.p("Step4 : 출시준비");
		}

		// if statement로 구현하면
		if(workProcess == 0) {
			Mu.p("Step1 : 작업준비");
			Mu.p("Step2 : 개발준비");
			Mu.p("Step3 : 개발완료");
			Mu.p("Step4 : 출시준비");
		}
		else if(workProcess == 1) {
			Mu.p("Step2 : 개발준비");
			Mu.p("Step3 : 개발완료");
			Mu.p("Step4 : 출시준비");
		}
		else if(workProcess == 2) {
			Mu.p("Step3 : 개발완료");
			Mu.p("Step4 : 출시준비");
		}
		else {
			Mu.p("Step4 : 출시준비");
		}
		
	}

}
