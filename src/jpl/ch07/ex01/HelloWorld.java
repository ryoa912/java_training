package jpl.ch07.ex01;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("H \u0b87 \u0b72 \u0b72 \u0b68, \u0b74 \u0b68 r \u0b72 \u0b37");
	}
}

//間違い。全てのソースコードを\XXXXで書かないとならない。
//コンバーターを作って、toUnicodeで変換してやるのが手っ取り早い