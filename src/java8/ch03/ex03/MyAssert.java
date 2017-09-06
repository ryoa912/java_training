/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex03;

public class MyAssert {
	public final boolean ENABLE = false;	//ここを書き換える←コンパイルスイッチのようなもの

	//C++などでは、コンパイル時にコンパイルスイッチで切り替える。それでもいいが、全ての箇所にif文が入ってしまう。
	//Javaでは、実行時に選択する。それにより、if文を加えずにランタイムコストを抑えることができる。

	//ライブラリを使う方法は、下記のように、定義して、
	//無効のときはPredicatedも処理しないようにすれば、ランタイムコストを抑えられる。
	//assert(Predicated, Supplier)
}