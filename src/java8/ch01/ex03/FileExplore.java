/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileExplore {
	public List<String> getFiles(File file, String ext) {
		List<String> list = Arrays.asList(file.list(
				(File f, String n) -> {return f.exists() && n.endsWith(ext);}
		));
		return list;
	}
	public static void main(String[] args) {
		FileExplore obj = new FileExplore();
		List<String> l = obj.getFiles(new File(new File(".").getAbsoluteFile().getParent()), ".md");

		for (int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}
	}


}
