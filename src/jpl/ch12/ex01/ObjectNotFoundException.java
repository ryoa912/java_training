package jpl.ch12.ex01;

public class ObjectNotFoundException extends Exception {
	public final Object object;
	public ObjectNotFoundException(Object obj) {
		super("Object not found");
		object = obj;
	}
}
