/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch23.ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ProcessSample2 {
	public static void main(String[] args) throws IOException {
		Process child = new ProcessBuilder(args[0]).redirectErrorStream(true).start();
		InputStream procOut = child.getInputStream();
		LineNumberReader in = new LineNumberReader(new InputStreamReader(procOut));

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(new StringBuilder().append(in.getLineNumber()).append(": ").append(line));
		}
	}
}
