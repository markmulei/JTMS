package com.jtms.core.util;

public class GuidUtil {

	private GuidUtil() {
	}

	public static String generate() {
		UUIDGenerator uGenerator = new UUIDGenerator();
		String uuid = String.valueOf(uGenerator.generate());
		return uuid;
	}

	public static void main(String a[]) {
		System.out.println(generate());
	}
}
