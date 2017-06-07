/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//ラムダ式を用いたバージョン

public class FileExplore {
	public List<File> getDirs(String path) {
		return searchDirs(new ArrayList<>(), new File(path));
	}

	private List<File> searchDirs(List<File> dList, File file) {
		List<File> dirs = Arrays.asList(file.listFiles((File f) -> f.exists() && f.isDirectory()));
		dList.addAll(dirs);
		return dList;
	}

	public static void main(String[] args) {
		FileExplore obj = new FileExplore();
		List<File> l = obj.getDirs(new File(".").getAbsoluteFile().getParent());
		for (int i=0; i<l.size(); i++)
			System.out.println(l.get(i).getName());
	}
}
