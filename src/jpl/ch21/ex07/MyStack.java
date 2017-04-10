/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex07;

import java.util.ArrayList;

public class MyStack extends ArrayList {
	//ArrayListのサブクラスとすべきか、内部で使用すべきか
	//→内部で使用すべき。（理由：サブクラスとすると、オーバーライドしていないメソッドについての動作保証も行わないとならないため。）
	private ArrayList al = new ArrayList();

	public void push(Object obj) {
	}

	public Object pop() {
		return null;
	}

}
