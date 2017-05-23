/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch24.ex01;

import java.util.ListResourceBundle;

public class GlobalRes_en extends ListResourceBundle {
	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";

	public Object[][] getContents() {
		return contents;
	}

	public static final Object[][] contents = {
			{ GlobalRes.HELLO, "Hello"},
			{ GlobalRes.GOODBYE, "Goodbye"},
	};
}
