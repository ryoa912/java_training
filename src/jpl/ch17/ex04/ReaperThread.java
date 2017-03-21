/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex04;

import java.lang.ref.Reference;

import javax.annotation.Resource;

public class ReaperThread extends Thread {
	public void run() {
		//割り込まれるまで実行
		while (true) {
			try {
				Reference<?> ref = queue.remove();
				Resource res = null;
				synchronized(ResourceManager.this) {
					res = refs.get(ref);
					refs.remove(ref);
				}
				res.release();
				ref.clear();
			}
			catch(InterruptedException ex) {
				break;	//全て終了
			}
		}
	}
}
