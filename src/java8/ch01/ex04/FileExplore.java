/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileExplore {

	public List<File> listFiles(String path) {
		File[] list = new File(path).listFiles();
		Arrays.sort(list, (File a, File b) -> {
			if (a.isDirectory() && !b.isDirectory()) {
				return -1;
			} else if (!a.isDirectory() && b.isDirectory()) {
				return 1;
			} else {
				return a.getName().compareTo(b.getName());
			}
		});
		return Arrays.asList(list);
}

	public static void main(String[] args) {
		List<File> l = new FileExplore().listFiles(new File(".").getAbsoluteFile().getParent());

		for (int i=0; i<l.size(); i++) {
			if (l.get(i).isDirectory())
				System.out.print("[Dir ]");
			else
				System.out.print("[File]");
			System.out.println(l.get(i).getPath());
		}
	}
}
