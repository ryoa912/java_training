package jpl.ch05.ex02;

import java.util.LinkedList;

public class BankAccount {
	private long number;	//口座番号
	private long balance;	//現在の残高
	private Action lastAct;	//最後に行われた処理
	private History history = new History();

	BankAccount(int number) {
		this.number = number;
	}

	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}
		public String toString() {
			// identify our enclosing account
			return number + ": " + act + " " + amount;
		}
	}

	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.add(lastAct);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("whitdraw", amount);
		history.add(lastAct);
	}

	public static class History {
		LinkedList<Action> actions = new LinkedList<Action>();
		private static final int HISTORY_NUM = 10;
		private int index;
		History() {
			index = actions.size();
		}
		public Action next() {
			Action ret = actions.get(index);
			index++;
			return ret;
		}
		public void add(Action newAction) {
			if (actions.size() >= HISTORY_NUM) {
				actions.removeFirst();
			}
			actions.addLast(newAction);
		}
	}

	public History history() {
		return history;
	}
}
