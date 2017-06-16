/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex11;

public class Sample {
	public static void main(String[] args) {
		SI.f();
		SJ.f();
		new IAndJ().f();
		new IAndDJ().f();
		new IAndSJ().f();
		new DIAndJ().f();
		new DIAndDJ().f();
		new DIAndSJ().f();
		new SIAndJ().f();
		new SIAndDJ().f();
		new SIAndSJ();
		new SS().f();
		new NS().f();
	}

	private static class IAndJ implements I, J {
		@Override
		public void f() {
			System.out.println("IAndJ.f()");
		}
	}
	private static class IAndDJ implements I, DJ {
		@Override
		public void f() {
			System.out.println("IAndDJ.f()");
		}
	}
	private static class IAndSJ implements I, SJ {
		@Override
		public void f() {
			System.out.println("IAndSJ.f()");
		}
	}
	private static class DIAndJ implements DI, J {
		@Override
		public void f() {
			System.out.println("DIAndJ.f()");
		}
	}
	private static class DIAndDJ implements DI, DJ {
		@Override
		public void f() {
			System.out.println("DIAndDJ.f()");
		}
	}
	private static class DIAndSJ implements DI, SJ {
		@Override
		public void f() {
			System.out.println("DIAndSJ.f()");
		}
	}
	private static class SIAndJ implements SI, J {
		@Override
		public void f() {
			System.out.println("SIAndJ.f()");
		}
	}
	private static class SIAndDJ implements SI, DJ {
		@Override
		public void f() {
			System.out.println("SIAndDJ.f()");
		}
	}
	private static class SIAndSJ implements SI, SJ {
		//Nothing.
	}
	private static class SS extends S {
		public void f() {
			System.out.println("SS.f()");
		}
	}
	private static class NS extends S {
		//Nothing.
	}
}
