/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch20.ex11;

import java.io.File;

public class SuffixFileFilter {
	private final File dir;
	private final String suffix;

	public SuffixFileFilter(String dir, String suffix) {
		this.dir = new File(dir);
		this.suffix = suffix;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(suffix);
	}

	public String[] list() {
		return dir.list();
	}

	public static void main(String[] args) {
		SuffixFileFilter filter = new SuffixFileFilter("/java_training", "java");
		for (String list : filter.list())
			System.out.println(list);
	}
}
