package jpl.ch04.ex03;

//インターフェース化すべきではない。
public interface LinkedList {
	public Object getObj();

	public void setObj(Object obj);

	public LinkedList getNext();

	public int length();

	public LinkedList clone();
}
