package jpl.ch12.ex01;

public class LinkedList<E> {
	private E obj;
	private LinkedList<E> next;

	public LinkedList(E object, LinkedList<E> previous) {
		obj = object;
		if (null != previous)
			previous.next = this;
	}

	public E getObj() {
		return obj;
	}

	public void setObj(E obj) {
		this.obj = obj;
	}

	public LinkedList<E> getNext() {
		return next;
	}

	public int length() {
		int ret = 1;

		if (next != null) {
			ret += next.length();;
		}

		return ret;
	}

	//先頭から辿っていって、最初に見つかったobjを含むLinkedListを返す。
	//終端まで行って見つからなければ、ObjectNotFoundExceptionを返す。
	public LinkedList<E> find(Object obj) throws ObjectNotFoundException {
		if (this.obj == obj) {
			return this;
		}
		if (next == null) {
			throw new ObjectNotFoundException(obj);
		} else {
			return next.find(obj);
		}
	}
}
