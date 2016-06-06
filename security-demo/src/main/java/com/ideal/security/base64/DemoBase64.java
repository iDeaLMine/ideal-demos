package com.ideal.security.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class DemoBase64 {

    private static String src = "iDeaL security base64";

    public static void main(String[] args) {
        jdkBase64();
        commonsCodesBase64();
        bouncyCastleBase64();
    }

    /**
     * jdk实现
     */
    public static void jdkBase64() {
        try {
            //编码
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(src.getBytes());
            System.out.println("encode : " + encode);

            //解码
            BASE64Decoder decoder = new BASE64Decoder();
            System.out.println("decode : " + new String(decoder.decodeBuffer(encode)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用commons-codec.jar
     */
    public static void commonsCodesBase64() {
        //编码
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode : " + new String(encodeBytes));

        //解码
        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println("decode : " + new String(decodeBytes));
    }

    /**
     * 使用bouncycastle
     */
    public static void bouncyCastleBase64() {
        //编码
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode : " + new String(encodeBytes));

        //解码
        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
        System.out.println("decode : " + new String(decodeBytes));
    }

}
