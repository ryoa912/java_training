/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

public class MyReader {
	private static final String PATH = "src/jpl/ch22/ex12/sample.txt";
	/**
	 * Scannerを使って入力されたAttrの属性を読み込む
	 * @param source
	 * @return
	 * @throws IOException
	 */
	public static Attributed readAttrs(Reader source) throws IOException {
		Attributed<String> attrs = new AttributedImpl();
        Scanner in = null;
        try {
            in = new Scanner(source);
            while (in.hasNextLine()) {
                String[] kv = in.nextLine().split("=");
                attrs.add(new Attr<>(kv[0], kv[1]));
            }
        } finally {
            if (in != null)
                in.close();
        }
        return attrs;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(PATH));
            Attributed<String> attrs = readAttrs(in);
            Iterator<Attr<String>> it = attrs.attrs();
            while (it.hasNext())
                System.out.println(it.next());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
        }
	}
}
