package jpl.ch10.ex03;

public class Work_switch {
	public final boolean isWorkDay(DayOfWeek d) throws IllegalArgumentException {
		switch (d) {
		case MONDAY:
			return true;
		case TUESDAY:
			return true;
		case WEDNESDAY:
			return true;
		case THURSDAY:
			return true;
		case FRIDAY:
			return true;
		case SATURDAY:
			return false;
		case SUNDAY:
			return false;
		default:
			throw new IllegalArgumentException();
		}
	}
}
