/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex13;

public interface Attributed<V> {
	void add(Attr<V> newAttr);
	Attr<V> find(String attrName);
	Attr<V> remove(String attrName);
	java.util.Iterator<Attr<V>> attrs();
}
