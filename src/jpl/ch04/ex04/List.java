package jpl.ch04.ex04;

public interface List {
	void add(Object o);
	void add(int i, Object o);
	Object get(int i);
	int indexOf(Object o);
	void remove(int i);
	void clear();
	int size();
}
