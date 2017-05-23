/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch24.ex02;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class CurrencySymbol {
	private static List<Locale> countries = new ArrayList<>();

	public static void main(String[] args) {
		countries.add(Locale.US);
		countries.add(Locale.UK);
		countries.add(Locale.GERMANY);
		countries.add(Locale.JAPAN);
		countries.add(Locale.CHINA);
		countries.add(Locale.CANADA);
		for (Locale loc : countries) {
			Currency cur = Currency.getInstance(loc);
			System.out.println(loc.toString() + "\t" + cur.getSymbol());
		}
	}
}
