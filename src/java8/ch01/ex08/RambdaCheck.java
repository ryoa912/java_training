/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public final class RambdaCheck {
	public static void check1() {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}
		runners.forEach(run -> run.run());
	}

	public static void check2() {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			runners.add(() -> System.out.println(name));
		}
		runners.forEach(run -> run.run());
	}

	public static void main(String[] args) {
		System.out.println("<check1>");
		RambdaCheck.check1();
		System.out.println("<check2>");
		RambdaCheck.check2();
	}
}
