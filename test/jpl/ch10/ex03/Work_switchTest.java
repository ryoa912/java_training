package jpl.ch10.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Work_switchTest {

	@Test
	public void testIsWorkDay_1() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.MONDAY);

		assertEquals(true, ans);
	}
	@Test
	public void testIsWorkDay_2() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.TUESDAY);

		assertEquals(true, ans);
	}
	@Test
	public void testIsWorkDay_3() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.WEDNESDAY);

		assertEquals(true, ans);
	}
	@Test
	public void testIsWorkDay_4() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.THURSDAY);

		assertEquals(true, ans);
	}
	@Test
	public void testIsWorkDay_5() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.FRIDAY);

		assertEquals(true, ans);
	}
	@Test
	public void testIsWorkDay_6() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.SATURDAY);

		assertEquals(false, ans);
	}
	@Test
	public void testIsWorkDay_7() {
		Work_switch w = new Work_switch();
		boolean ans = w.isWorkDay(DayOfWeek.SUNDAY);

		assertEquals(false, ans);
	}

}
