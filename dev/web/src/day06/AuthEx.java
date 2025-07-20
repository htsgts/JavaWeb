package day06;

import utils.Mu;

public class AuthEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myclass c = new Myclass();
		Mu.p("c.var1 = " + c.var1);
		Mu.p("c.var2 = " + c.getVar2());
		c.setVar2(5000);
		Mu.p("c.var2 = " + c.getVar2());
	}

}

class Myclass {
	public int var1 = 3;
	private int var2 = 10;
	
	// 변수는 대부분 private
	// => 변수마다 set/get이 존재할 경우가 많으며 setter/getter라고 부름
	public int getVar2() {
		return var2;
	}
	
	public void setVar2(int var) {
		var2 = var;
	}
	
}