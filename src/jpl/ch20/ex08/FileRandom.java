/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRandom {
	public static final void readFile(String filepath) throws FileNotFoundException {
		File file = new File(filepath);
		FileReader filereader = new FileReader(file);
		//区切ったデータをテーブルに保持する処理
	}
	public static final void writeRandom() {
		//テーブルに保持したデータから、ランダムに選択して出力する処理
	}
	static void main(String[] args) throws FileNotFoundException {
		//カレントディレクトリを表示
		String path = new File(".").getAbsoluteFile().getParent();
        System.out.println(path);

        readFile(path + "src\\jpl\\ch20\\ex08\\target.txt");

        writeRandom();
	}
}
