/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.components;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyInstance {
	protected final Object object;
	protected final String name;

	public MyInstance(Object object, String name) {
		this.object = object;
		this.name = name;
	}

	public Object getObject() {
		return object;
	}

	public String getName() {
		return name;
	}

	/**
	 * Get all fields.
	 *
	 * @return List of fields
	 */
	public List<MyField> getFields() {
		Set<MyField> fieldSet = new HashSet<>();
		for (Field f : object.getClass().getFields())
			fieldSet.add(new MyField(f, this));
		for (Field f : object.getClass().getDeclaredFields())
			fieldSet.add(new MyField(f, this));
		return new ArrayList<>(fieldSet);
	}

	/**
	 * Get all methods.
	 *
	 * @return List of methods
	 */
	public List<MyMethod> getMethods() {
		Set<MyMethod> methodSet = new HashSet<>();
		for (Method m : object.getClass().getMethods())
			methodSet.add(new MyMethod(m, this));
		for (Method m : object.getClass().getDeclaredMethods())
			methodSet.add(new MyMethod(m, this));
		List<MyMethod> methodList = new ArrayList<>(methodSet);
		Collections.sort(methodList);
		return methodList;
	}

	@Override
	public String toString() {
		return name;
	}
}
