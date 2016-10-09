package jpl.ch01.ex10;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static Term[] terms;

	public static void main(String[] args) {
		int lo=1, hi=1;

		terms = new Term[MAX_INDEX];
		for (int i=0; i<MAX_INDEX; i++) {
			terms[i] = new Term();
		}

		terms[0].num = hi;
		terms[0].even = false;

		for (int i=2; i<=MAX_INDEX; i++) {

			if (hi % 2 == 0)
				terms[i-1].even = true;
			else
				terms[i-1].even = false;

			terms[i-1].num = hi;

			hi = lo + hi;
			lo = hi - lo;

		}

		//Output
		for (int i=0; i<MAX_INDEX; i++) {
			String mark = "";
			if (terms[i].even==true)
				mark = "*";
			else
				mark = "";
			System.out.println(i+1 + ": " + terms[i].num + " "+ mark);
		}
	}
}
