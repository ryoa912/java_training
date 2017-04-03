/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex09;

import java.io.File;

public class FileProperty {
	public static void main(String[] args) {
		//カレントディレクトリを表示
		String path = new File(".").getAbsoluteFile().getParent();
        System.out.println(path);

		//引数にファイル名がなければ警告を出して終了
		if (args.length <= 0) {
			System.out.println("input file path.");
			return;
		}

		File f;
		//引数が複数の場合、その分周回
		for (int i =0; i<args.length; i++) {
			f = new File(args[i]);
			if (!f.exists()) {
				System.out.println("[" + args[i] + "]Not exists.");
			} else {
				System.out.println("[" + args[i] + "]length:" + f.length());	//バイト数
				System.out.println("[" + args[i] + "]AbsolutePath:" + f.getAbsolutePath());	//絶対ファイルパス
				System.out.println("[" + args[i] + "]Parent:" + f.getParent());	//親フォルダ名
			}
		}
	}
}
