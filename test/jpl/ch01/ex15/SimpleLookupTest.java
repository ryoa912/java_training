package jpl.ch01.ex15;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class SimpleLookupTest {

	@Test
	public void testFind() {
		SimpleLookup obj = new SimpleLookup();

		String[] names = new String[1];
		names[0] = "null";
		Object[] values = new Object[1];
		values[0] = null;

		Deencapsulation.setField(obj, "names", names);
		Deencapsulation.setField(obj, "values", values);

		Object value = obj.find("null");

		assertEquals(null, value);
	}

	@Test
	public void testAdd() {
		SimpleLookup obj = new SimpleLookup();
		obj.add("null", null);

		String[] names = Deencapsulation.getField(obj, "names");
		Object[] values = Deencapsulation.getField(obj, "values");

		assertEquals(names[0], "null");
		assertEquals(values[0], null);
	}

	@Test
	public void testRemove() {
		SimpleLookup obj = new SimpleLookup();

		String[] names = new String[1];
		names[0] = "null";
		Object[] values = new Object[1];
		values[0] = null;

		Deencapsulation.setField(obj, "names", names);
		Deencapsulation.setField(obj, "values", values);

		obj.remove("null");

		String[] acutualNames = Deencapsulation.getField(obj, "names");
		Object[] acutualValues = Deencapsulation.getField(obj, "values");

		assertEquals(0, acutualNames.length);
		assertEquals(0, acutualValues.length);
	}

}
