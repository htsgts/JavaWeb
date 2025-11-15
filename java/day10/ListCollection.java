package day10;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ArrayList
		ArrayList al = new ArrayList();
		
		// (1) 리스트에 요소 추가(add)
		al.add("돈까스");
		al.add("치킨까스");
		al.add("쌀국수");
		al.add("라면");
		System.out.println(al);
		
		for(int i=0; i<al.size(); i++) {
			System.out.println(i + ":" + al.get(i));  // get(i) i에 해당하는 데이터 가져오기
		}
		
		// (2) 요소 삭제(remove)
		al.remove(1);
		System.out.println(al);
		al.remove("돈까스");
		System.out.println(al);
		
		// (3) 요소 변경(set)
		al.set(0, "빠에야");
		System.out.println(al);
		
		try {
			System.out.println(al.get(100));
		}
		catch(Exception e) {
			System.out.println("니가 해먹어");
		}
		
		// (4) 요소가 있는지 알아보기(contains)
		System.out.println("돈까스있나연? " + al.contains("돈까스"));
		System.out.println("라면있나연? " + (al.contains("라면")? "응":"아니없어"));
		
		// 2. LinkedList
		LinkedList ll = new LinkedList();
		ll.add("슬램덩크");
		ll.add(0, "데몬헌터스");
		ll.add(1, "사랑의하츄핑");
		System.out.println(ll);
		
		// 3. Performance
		ArrayList app1 = new ArrayList();
		LinkedList app2 = new LinkedList();
		
		final int SAMPLE = 10000;
		for(int i=0; i<SAMPLE; i++) {
			app1.add(i);
			app2.add(i);
		}
		
		// read test
		long start, mid, end;
		start = System.currentTimeMillis();
		for(int i=0; i<SAMPLE; i++)
			app1.get(i);
		mid = System.currentTimeMillis();
		for(int i=0; i<SAMPLE; i++)
			app2.get(i);
		end = System.currentTimeMillis();
		
		System.out.println("***** Read Competition *****");
		System.out.println("ArrayList : " + (mid-start));
		System.out.println("LinkedList : " + (end-mid));
		
		// insert test
		start = System.currentTimeMillis();
		for(int i=0; i<10000; i++)
			app1.add(500, i);
		mid = System.currentTimeMillis();
		for(int i=0; i<10000; i++)
			app2.add(500, i);
		end = System.currentTimeMillis();
		
		System.out.println("***** Insert Competition *****");
		System.out.println("ArrayList : " + (mid-start));
		System.out.println("LinkedList : " + (end-mid));
		
		
	}

}
