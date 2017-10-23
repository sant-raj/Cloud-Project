package com.cluster.util;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class CustomKey {

	public static String generateKey() {

		String pk = "";
		try {

			KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
			KeyPair kp = kg.generateKeyPair();
			Key pubKey = kp.getPublic();
			byte[] pub = pubKey.getEncoded();
			pk = String.valueOf(pub);

		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
		return pk;
	}

}
