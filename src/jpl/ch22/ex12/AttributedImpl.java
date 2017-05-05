/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AttributedImpl implements Attributed<String>{
	protected Map<String, Attr<String>> attrTable =
			new HashMap<String, Attr<String>>();

	public void add(Attr<String> newAttr) {
		attrTable.put(newAttr.getName(), newAttr);
	}

	public Attr<String> find(String name) {
		return attrTable.get(name);
	}

	public Attr<String> remove(String name) {
		return attrTable.remove(name);
	}

	public Iterator<Attr<String>> attrs() {
		return attrTable.values().iterator();
	}
}
