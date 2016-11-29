package jpl.ch05.ex02;

import org.junit.Test;

import jpl.ch05.ex02.BankAccount.Action;
import jpl.ch05.ex02.BankAccount.History;

public class BankAccountTest {

	@Test
	public void testHistory() {
		BankAccount obj = new BankAccount(123456);

		obj.deposit(100);	//1
		obj.deposit(200);	//2
		obj.deposit(300);	//3
		obj.withdraw(200);	//4
		obj.deposit(500);	//5
		obj.withdraw(500);	//6
		obj.deposit(700);	//7
		obj.withdraw(600);	//8
		obj.deposit(900);	//9
		obj.deposit(1000);	//10
		obj.withdraw(1100);	//11

		History hist = obj.history();

		for (int i=0; ;i++) {
			Action act = hist.next();
			if (null == act) {
				break;
			}
			System.out.println(act.toString());
		}
	}

}
