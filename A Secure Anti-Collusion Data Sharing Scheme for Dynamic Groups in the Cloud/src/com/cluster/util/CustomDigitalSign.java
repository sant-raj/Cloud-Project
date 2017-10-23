package com.cluster.util;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class CustomDigitalSign {

	@SuppressWarnings("resource")
	public static String digitalSign(String content) {

		String digitalSign = "";
		String fromFile = "NeoFile";
		try {

			PrintStream printStream = new PrintStream(new FileOutputStream(
					"D:/NeoRays/" + fromFile));
			printStream.print(new String(content));
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			FileInputStream fileInputStream = new FileInputStream("D:/NeoRays/"
					+ fromFile);

			DigestInputStream digestInputStream = new DigestInputStream(
					fileInputStream, messageDigest);

			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					digestInputStream);
			while (true) {
				int b1 = bufferedInputStream.read();
				if (b1 == -1)
					break;
			}
			BigInteger bigInteger = new BigInteger(messageDigest.digest());
			digitalSign = bigInteger.toString(16);
		} catch (Exception e) {
			System.err.println(e);
		}
		return digitalSign;
	}

}
