/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex15;

import java.util.Stack;

public class MyCalculator {
	private Stack<Double> stack = new Stack<>();
	/**
	 * 基本演算子(+,-,*,/,%),全てのMath機能を実現する。
	 * @param val 入力値
	 * @return 出力値（出力が無い場合はnull）
	 */
	public String calculate(String val) {
		String answer = null;
		double e1 = 0;
		double e2 = 0;
		switch (val) {
		case "+":
			e1 = stack.pop();
			e2 = stack.pop();
			return String.valueOf(e2 + e1);
		case "-":
			e1 = stack.pop();
			e2 = stack.pop();
			return String.valueOf(e2 - e1);
		case "*":
			e1 = stack.pop();
			e2 = stack.pop();
			return String.valueOf(e2 * e1);
		case "/":
			e1 = stack.pop();
			e2 = stack.pop();
			return String.valueOf(e2 / e1);
		case "%":
			e1 = stack.pop();
			e2 = stack.pop();
			return String.valueOf(e2 % e1);
		case "sin":
			return String.valueOf(Math.sin(stack.pop()));
		case "cos":
			return String.valueOf(Math.cos(stack.pop()));
		case "tan":
			return String.valueOf(Math.tan(stack.pop()));
		case "asin":
			return String.valueOf(Math.asin(stack.pop()));
		case "acos":
			return String.valueOf(Math.acos(stack.pop()));
		case "atan":
			return String.valueOf(Math.atan(stack.pop()));
		case "atan2":
			e1 = stack.pop();
			e2 = stack.pop();
			return String.valueOf(Math.atan2(e2, e1));
		case "toRadians":
			return String.valueOf(Math.toRadians(stack.pop()));
		case "toDegrees":
			return String.valueOf(Math.toDegrees(stack.pop()));
		case "exp":
			return String.valueOf(Math.exp(stack.pop()));
		case "sinh":
			return String.valueOf(Math.sinh(stack.pop()));
		case "cosh":
			return String.valueOf(Math.cosh(stack.pop()));
		case "tanh":
			return String.valueOf(Math.tanh(stack.pop()));
		case "pow":
			return String.valueOf(Math.pow(stack.pop(), stack.pop()));
		case "log":
			return String.valueOf(Math.log(stack.pop()));
		case "log10":
			return String.valueOf(Math.log10(stack.pop()));
		case "sqrt":
			return String.valueOf(Math.sqrt(stack.pop()));
		case "cbrt":
			return String.valueOf(Math.cbrt(stack.pop()));
		case "signum":
			return String.valueOf(Math.signum(stack.pop()));
		case "ceil":
			return String.valueOf(Math.ceil(stack.pop()));
		case "floor":
			return String.valueOf(Math.floor(stack.pop()));
		case "rint":
			return String.valueOf(Math.rint(stack.pop()));
		case "round":
			return String.valueOf(Math.round(stack.pop()));
		case "abs":
			return String.valueOf(Math.abs(stack.pop()));
		case "max":
		    e1 = stack.pop();
		    e2 = stack.pop();
			return String.valueOf(Math.max(e2, e1));
		case "min":
		    e1 = stack.pop();
		    e2 = stack.pop();
			return String.valueOf(Math.min(e2, e1));
		case "hypot":
		    e1 = stack.pop();
		    e2 = stack.pop();
			return String.valueOf(Math.hypot(e2, e1));
		default:
			stack.push(Double.parseDouble(val));
		}
		return answer;
	}

	public static void main(String[] args) {
		MyCalculator cal = new MyCalculator();
		cal.calculate("1");
		cal.calculate("1");
		System.out.println(cal.calculate("+"));
	}
}
