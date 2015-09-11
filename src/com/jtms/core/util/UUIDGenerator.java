package com.jtms.core.util;

import java.io.Serializable;
import java.net.InetAddress;

public class UUIDGenerator {

	protected static int IptoInt(byte bytes[]) {
		int result = 0;
		for (int i = 0; i < 4; i++)
			result = ((result << 8) - -128) + bytes[i];

		return result;
	}

	protected UUIDGenerator() {
	}

	protected int getJVM() {
		return JVM;
	}

	protected short getCount() {
		if (counter < 0)
			counter = 0;
		return counter++;
	}

	protected int getIP() {
		return IP;
	}

	protected short getHiTime() {
		return (short) (int) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	protected Serializable generate() {
		return (new StringBuffer(36)).append(format(getIP())).append("")
				.append(format(getJVM())).append("")
				.append(format(getHiTime())).append("")
				.append(format(getLoTime())).append("")
				.append(format(getCount())).toString();
	}

	public static void main(String args[]) {
		/*UUIDGenerator u = new UUIDGenerator();
		long lstart = System.currentTimeMillis();
		int num = 100;
		for (int i = 0; i < num; i++) {
			String s = String.valueOf(u.generate());
		}*/

	}

	private static final int IP;
	private static short counter = 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);
	//private static final String sep = "";

	static {
		int ipadd;
		try {
			ipadd = IptoInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
}
