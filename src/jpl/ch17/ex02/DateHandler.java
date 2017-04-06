/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex02;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.file.Files;

public class DateHandler {
	private WeakReference<File> lastFile;		//（おそらく）最後に読んだファイル
	private WeakReference<byte[]> lastData;	//（おそらく）最後のデータ

	byte[] readFile(File file) throws IOException {
		File lf;
		byte[] data;

		//Fileを記憶しているか調べる
		lf = lastFile.get();
		if (lf != null) {
			//データを記憶しているか調べる
			if (file.equals(lastFile)) {
				data = lastData.get();
				if (data != null) {
					return data;
				}
			}
		}

		//記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	private byte[] readBytesFromFile(File file) throws IOException {
		return Files.readAllBytes(file.toPath());
	}
}
