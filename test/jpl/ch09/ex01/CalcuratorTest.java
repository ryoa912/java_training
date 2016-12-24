package jpl.ch09.ex01;

import org.junit.Test;

public class CalcuratorTest {

	@Test
	public void testAddFloat_pp() {
		float ret =  Calcurator.addFloat(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testAddFloat_pn() {
		float ret =  Calcurator.addFloat(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testAddFloat_nn() {
		float ret =  Calcurator.addFloat(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

	@Test
	public void testSubFloat_pp() {
		float ret =  Calcurator.subFloat(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testSubFloat_pn() {
		float ret =  Calcurator.subFloat(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testSubFloat_nn() {
		float ret =  Calcurator.subFloat(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}


	@Test
	public void testMulFloat_pp() {
		float ret =  Calcurator.mulFloat(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testMulFloat_pn() {
		float ret =  Calcurator.mulFloat(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testMulFloat_np() {
		float ret =  Calcurator.mulFloat(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testMulFloat_nn() {
		float ret =  Calcurator.mulFloat(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

	@Test
	public void testDivFloat_pp() {
		float ret =  Calcurator.divFloat(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testDivFloat_pn() {
		float ret =  Calcurator.divFloat(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testDivFloat_np() {
		float ret =  Calcurator.divFloat(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testDivFloat_nn() {
		float ret =  Calcurator.divFloat(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

	@Test
	public void testAddDouble_pp() {
		double ret =  Calcurator.addDouble(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testAddDouble_pn() {
		double ret =  Calcurator.addDouble(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testAddDouble_np() {
		double ret =  Calcurator.addDouble(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testAddDouble_nn() {
		double ret =  Calcurator.addDouble(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

	@Test
	public void testSubDouble_pp() {
		double ret =  Calcurator.subDouble(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testSubDouble_pn() {
		double ret =  Calcurator.subDouble(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testSubDouble_np() {
		double ret =  Calcurator.subDouble(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testSubDouble_nn() {
		double ret =  Calcurator.subDouble(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

	@Test
	public void testMulDouble_pp() {
		double ret =  Calcurator.mulDouble(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testMulDouble_pn() {
		double ret =  Calcurator.mulDouble(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testMulDouble_np() {
		double ret =  Calcurator.mulDouble(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testMulDouble_nn() {
		double ret =  Calcurator.mulDouble(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

	@Test
	public void testDivDouble_pp() {
		double ret =  Calcurator.divDouble(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testDivDouble_pn() {
		double ret =  Calcurator.divDouble(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testDivDouble_np() {
		double ret =  Calcurator.divDouble(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		System.out.println(ret);
	}
	@Test
	public void testDivDouble_nn() {
		double ret =  Calcurator.divDouble(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		System.out.println(ret);
	}

}
