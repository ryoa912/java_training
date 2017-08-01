/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class ComparatorMaker {
	public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
		return (first, second) -> {
			for (String fieldName : fieldNames) {
				Comparable<?> firstValue = null;
				Comparable<?> secondValue = null;
				try {
					Field firstField = first.getClass().getField(fieldName);
					firstField.setAccessible(true);
					firstValue = (Comparable) firstField.get(first);
					Field secondField = second.getClass().getField(fieldName);
					secondField.setAccessible(true);
					secondValue = (Comparable) secondField.get(second);
				} catch (ReflectiveOperationException e) {
					System.err.println("ERROR: " + e);
					continue;
				}
				if (firstValue != null && secondValue != null) {
					@SuppressWarnings("unchecked")
					int compare = ((Comparable) firstValue).compareTo(secondValue);
					if (compare != 0) {
						return compare;
					}
				}
			}
			return 0;
		};
	}

	public static class TwoObjects {

		public String firstName;
		public String lastName;

		public TwoObjects(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}

	public static void main(String[] args) {
		Comparator<TwoObjects> cmp = ComparatorMaker.lexicographicComparator("firstName", "lastName");
		int result = cmp.compare(new TwoObjects("A", "B"), new TwoObjects("A", "B"));
		System.out.println("Compared result = " + result);
	}
}
