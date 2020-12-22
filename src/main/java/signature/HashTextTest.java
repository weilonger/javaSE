package main.java.signature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class HashTextTest {

    /**
     * @param args
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String secure_key = "XiguaTv_bu3e90pall01f7b4f3sg";
        Random random = new Random();
        int num = 0;
        while (num == 0) {
            num = random.nextInt(1000000000);
        }
        String salt = String.valueOf(num);
        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(
                "secure_key = " + secure_key + "\n" +
                "timestamp = " + timestamp + "\n" +
                "salt = " + salt + "\n"
        );
        String[] arrs = new String[]{secure_key, timestamp, salt};
        Arrays.sort(arrs);
        StringBuffer result = new StringBuffer();
        for (String s : arrs) {
            result.append(s);
        }
//        System.out.println(result.toString());
        System.out.println(sha1(result.toString()));
    }

    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}