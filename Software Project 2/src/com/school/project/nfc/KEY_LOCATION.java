package com.school.project.nfc;

public enum KEY_LOCATION {
	ZERO((byte)0x00),
	ONE((byte)0x01);
	
	private byte value;
	private KEY_LOCATION(byte v) {
		value = v;
	}
	public byte getValue() {
		return value;
	}
	
	public static KEY_LOCATION valueOfByte(byte b) {
		return b == (byte)0x00 ? ZERO : ONE;
	}
}
