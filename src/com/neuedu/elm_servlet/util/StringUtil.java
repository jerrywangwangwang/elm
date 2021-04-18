package com.neuedu.elm_servlet.util;

public class StringUtil {
	
	public static boolean isNotEmpty(Object str) {
		return str!=null && ! "".equals(str);
	}
	public static boolean isEmpty(Object str) {
		return str==null ||"".equals(str);
	}
}
