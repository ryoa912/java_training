/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex01;

public final class GarbageCollectionChecker {
	private String str10;

	public void setInstance() {
		str10 = new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	public void deleteInstance() {
		str10 = null;
	}


	public static void main(String[] args) {
		long fm;
		GarbageCollectionChecker obj = new GarbageCollectionChecker();

		//最大メモリサイズ
		fm = Runtime.getRuntime().maxMemory();
		System.out.println("最大値:" + fm + "byte");

		//実施前
		fm = Runtime.getRuntime().freeMemory();
		System.out.println("生成前:" + fm + "byte");

		//インスタンス生成後
		obj.setInstance();
		fm = Runtime.getRuntime().freeMemory();
		System.out.println("生成後:" + fm + "byte");

		//インスタンス削除後
		obj.deleteInstance();
		fm = Runtime.getRuntime().freeMemory();
		System.out.println("削除後:" + fm + "byte");

		//GC後
		Runtime.getRuntime().gc();
		fm = Runtime.getRuntime().freeMemory();
		System.out.println("ＧＣ後:" + fm + "byte");
	}
}
