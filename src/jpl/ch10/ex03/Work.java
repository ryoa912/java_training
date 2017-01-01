package jpl.ch10.ex03;

public class Work {
	public final boolean isWorkDay(DayOfWeek d) throws IllegalArgumentException {
		if (d == DayOfWeek.MONDAY)
			return true;
		else if (d == DayOfWeek.TUESDAY)
			return true;
		else if (d == DayOfWeek.WEDNESDAY)
			return true;
		else if (d == DayOfWeek.THURSDAY)
			return true;
		else if (d == DayOfWeek.FRIDAY)
			return true;
		else if (d == DayOfWeek.SATURDAY)
			return false;
		else if (d == DayOfWeek.SUNDAY)
			return false;
		else
			throw new IllegalArgumentException();
	}
}
