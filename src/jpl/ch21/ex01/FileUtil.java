/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class FileUtil {
	private LinkedList<String> l = new LinkedList<String>();	//未ソートのリスト

	public void makeListFromFile(File f) throws IOException {
		FileReader fr = new FileReader(f);
		RowFileReader r = new RowFileReader(fr);
		String s;
		while(true) {
			s = r.readRow();
			if (s == null)
				return;
			l.addLast(s);
		}
	}

	public void sortList() {
		Collections.sort(l);
	}

	public void printList() {
		Iterator<String> i = l.iterator();
		while(i.hasNext()) {
			String s = i.next();
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		if (args.length <= 0)
			return;
		File f = new File(args[0].toString());
		FileUtil fu = new FileUtil();
		try {
			fu.makeListFromFile(f);
			fu.sortList();
			fu.printList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
