package jpl.ch04.ex04;

public interface Map {
	void add(Object o);
	void add(String key, Object o);
	Object get(String key);
	int indexOf(Object o);
	void remove(String key);
	void clear();
	int size();
}
