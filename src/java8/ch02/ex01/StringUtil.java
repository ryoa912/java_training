/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
	public static final int count() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("src/java8/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);
		//ファイルを文字列へ読み込む
		List<String> words = Arrays.asList(contents.split("[//P{L}]+"));

		int count = 0;
		for (String w : words) {
			if (w.length() > 12) count++;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(StringUtil.count());
	}
}
