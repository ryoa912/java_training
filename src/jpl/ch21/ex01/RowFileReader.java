/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RowFileReader extends BufferedReader{
	public RowFileReader(FileReader filereader) {
		super(filereader);
	}

	public String readRow() throws IOException {
		return this.readLine();
	}
}
