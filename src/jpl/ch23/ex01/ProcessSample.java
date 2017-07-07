/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProcessSample {
	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	// ...plugTogether の定義 ...
	private static void plugTogether(InputStream inputStream, OutputStream outputStream) {
		new Thread(new MyProcess(inputStream, outputStream)).start();
	}

	private static void plugTogether(OutputStream outputStream, InputStream inputStream) {
		new Thread(new MyProcess(inputStream, outputStream)).start();
	}

	private static class MyProcess implements Runnable {

		private final InputStream in;
		private final OutputStream out;

		public MyProcess(InputStream in, OutputStream out) {
			this.in = in;
			this.out = out;
		}

		@Override
		public void run() {
			int ch;
			try {
				while ((ch = in.read()) != -1)
					out.write(ch);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
        try {
            Process proc = ProcessSample.userProg("java -version");
            System.out.println(proc.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
	}
}
