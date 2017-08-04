/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex12;

public interface Collection2 {
	//Collectionインターフェースのvoid stream()というメソッドを自分で作ってJava1.7でビルド（成功）
	//それをJava1.8環境で実行するとどうなる？⇒実行できる。自分が作って作ったメソッドが呼ばれる
	//（Java1.8で新たに実装されたCollectionインターフェースのstream()が呼び出されるわけではない。）
	//理由としては、戻り値の型が違うため。

	//互換性には3種類ある
	//・Source Compatibility(ソースコード互換性、ビルドできる/できない)
	//・Binary Compatibility（バイナリ互換性、ビルドできるけどバイナリが実行できない）
	//・Function Compatibility（機能互換性、動くけど使うとバグが起きる）
}
