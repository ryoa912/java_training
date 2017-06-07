/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//メソッド参照を用いたバージョン

public class FileExplore2 {
	public List<File> getDirs(String path) {
		return searchDirs(new ArrayList<>(), new File(path));
	}

	private List<File> searchDirs(List<File> dList, File file) {
		List<File> dirs = Arrays.asList(file.listFiles(File::isDirectory));
		dList.addAll(dirs);
		return dList;
	}

	public static void main(String[] args) {
		FileExplore2 obj = new FileExplore2();
		List<File> l = obj.getDirs(new File(".").getAbsoluteFile().getParent());
		for (int i=0; i<l.size(); i++)
			System.out.println(l.get(i).getName());
	}
}
