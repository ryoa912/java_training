/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch24.ex01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
	public static void main(String[] args) {
		//Locale.setDefault(Locale.ENGLISH);
		Locale.setDefault(Locale.JAPAN);

		ResourceBundle res =
				ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes");
		String msg;
		if (args.length > 0) {
			msg = res.getString(GlobalRes.GOODBYE);
		} else {
			msg = res.getString(GlobalRes.HELLO);
		}
		System.out.println(msg);
	}
}
