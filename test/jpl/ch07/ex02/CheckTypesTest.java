package jpl.ch07.ex02;

import org.junit.Test;

public class CheckTypesTest {

	@Test
	public void test1() {
		CheckTypes obj = new CheckTypes();

		System.out.println("[boolean]");
		obj.f_boolean = (boolean)CheckTypes.Literals.BOOLEAN_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.CHAR_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.BYTE_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.SHORT_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.INT_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.LONG_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.FLOAT_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_boolean = (boolean)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[char]");
//		obj.f_char = (char)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.INT_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.LONG_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_char = (char)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_char = (char)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[byte]");
//		obj.f_byte = (byte)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.INT_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.LONG_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_byte = (byte)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_byte = (byte)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[short]");
//		obj.f_short = (short)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.INT_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.LONG_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_short = (short)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_short = (short)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[int]");
//		obj.f_int = (int)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.INT_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.LONG_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_int = (int)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_int = (int)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[long]");
//		obj.f_long = (long)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.INT_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.LONG_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_long = (long)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_long = (long)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[float]");
//		obj.f_float = (float)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.INT_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.LONG_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_float = (float)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_float = (float)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[double]");
//		obj.f_double = (double)CheckTypes.Literals.BOOLEAN_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.CHAR_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.BYTE_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.SHORT_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.INT_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.LONG_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.FLOAT_LITERAL;
		obj.f_double = (double)CheckTypes.Literals.DOUBLE_LITERAL;
//		obj.f_double = (double)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);

		System.out.println("[String]");
//		obj.f_string = (String)CheckTypes.Literals.BOOLEAN_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.CHAR_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.BYTE_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.SHORT_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.INT_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.LONG_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.FLOAT_LITERAL;
//		obj.f_string = (String)CheckTypes.Literals.DOUBLE_LITERAL;
		obj.f_string = (String)CheckTypes.Literals.STRING_LITERAL;
		printFields(obj);
	}

	public static void printFields(CheckTypes obj) {
		System.out.println("f_boolean:" + obj.f_boolean
				+ ", f_char:" + obj.f_char
				+ ", f_byte:" + obj.f_byte
				+ ", f_short:" + obj.f_short
				+ ", f_int:" + obj.f_int
				+ ", f_long:" + obj.f_long
				+ ", f_float:" + obj.f_float
				+ ", f_double:" + obj.f_double
				+ ", f_string:" + obj.f_string
				);
	}

}
