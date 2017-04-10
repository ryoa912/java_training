/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.WeakHashMap;

public class DataHandler {
	private File lastFile;							//最後に読んだファイル
	private WeakHashMap<String, byte[]> lastData;	//おそらく最後のデータ
	private String KEY = "key";						//ハッシュマップ用のキー

	public byte[] readFile(File file) throws IOException {
		byte[] data;

		//データを記憶しているか調べる
		if (file.equals(lastFile)) {
			data = lastData.get(KEY);
			if (data != null)
				return data;
		}

		//記憶していないので読み込む
		data = readBytesFromFile(file);
		lastFile = file;
		lastData.put(KEY, data);
		return data;
	}

	private byte[] readBytesFromFile(File file) throws IOException {
		return Files.readAllBytes(file.toPath());
	}
}
