package jpl.ch07.ex02;

public class CheckTypes {
	//boolean
	public boolean f_boolean;

	//char
	public char f_char;

	//byte
	public byte f_byte;

	//short
	public short f_short;

	//int
	public int f_int;

	//long
	public long f_long;

	//float
	public float f_float;

	//double
	public double f_double;

	//Object
	public String f_string;

	public static class Literals {
        public static final boolean BOOLEAN_LITERAL = true;
        public static final char CHAR_LITERAL = 'a';
        public static final byte BYTE_LITERAL = Byte.MAX_VALUE;
        public static final short SHORT_LITERAL = Short.MAX_VALUE;
        public static final int INT_LITERAL = Integer.MAX_VALUE;
        public static final long LONG_LITERAL = Long.MAX_VALUE;
        public static final float FLOAT_LITERAL = Float.MAX_VALUE;
        public static final double DOUBLE_LITERAL = Double.MAX_VALUE;
        public static final String STRING_LITERAL = "Hello, World";
    }
}