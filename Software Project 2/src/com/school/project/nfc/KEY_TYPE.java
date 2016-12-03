package com.school.project.nfc;

public enum KEY_TYPE {
	A((byte)0x60),
	B((byte)0x61);
	
	private byte value;
	private KEY_TYPE(byte v) {
		value = v;
	}
	public byte getValue() {
		return value;
	}
	
	public static KEY_TYPE valueOfByte(byte b) {
		return b == (byte)0x60 ? A : B;
	}
}
