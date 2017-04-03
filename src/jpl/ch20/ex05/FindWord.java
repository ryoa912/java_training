/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex05;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindWord {
	public static void main(String[] args)
		throws IOException
	{
		String path = new File(".").getAbsoluteFile().getParent();
        System.out.println(path);
		if (args.length != 2) {
			throw new IllegalArgumentException("need word and file");
		}
		String match = args[0];
		FileReader fileIn = new FileReader(args[1]);
		LineNumberReader in = new LineNumberReader(fileIn);
		String row;
		while ( (row = in.readLine()) != null) {
			if (row.contains(match)) {
				System.out.println(in.getLineNumber() + ":" + row);
			}
		}
		System.out.println("arrived at the end of file");
	}
}
