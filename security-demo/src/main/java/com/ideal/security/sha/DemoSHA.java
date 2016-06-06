package com.ideal.security.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

public class DemoSHA {
	
	private static String src = "iDeaL security sha";

	public static void main(String[] args) {
		 jdkSHA1();
		 bcSHA1();
		 bcSHA224();
		 ccSHA1();
	}
	
	public static void jdkSHA1() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(src.getBytes());
			System.out.println("jdk sha-1 : " + Hex.encodeHexString(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println("bc sha-1 : " + Hex.encodeHexString(sha1Bytes));
	}
	
	public static void bcSHA224() {
		Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha224Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha224Bytes, 0);
		System.out.println("bc sha-224 : " + Hex.encodeHexString(sha224Bytes));
	}
	

	public static void ccSHA1() {
		System.out.println("cc sha1 - 1 :" + DigestUtils.sha1Hex(src.getBytes()));
		System.out.println("cc sha1 - 2 :" + DigestUtils.sha1Hex(src));
	}
	

}
