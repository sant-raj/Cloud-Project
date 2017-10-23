package com.cluster.util;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CustomEncryption {

	public static final String DEFAULT_ENCODING = "UTF-8";
	static BASE64Encoder enc = new BASE64Encoder();
	static BASE64Decoder dec = new BASE64Decoder();

	public static String fileEncryption(String content) {
		String encryptedContent = "";
		try {
			encryptedContent = enc.encode(content.getBytes(DEFAULT_ENCODING));
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
		return encryptedContent;
	}

	public static String fileDecryption(String content) {
		String decryptedContent = "";

		try {
			decryptedContent = new String(dec.decodeBuffer(content),
					DEFAULT_ENCODING);
		} catch (IOException e) {
			System.err.println(e);
		}
		return decryptedContent;
	}

}
