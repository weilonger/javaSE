package main.java.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * IqiyiTokenUtils.
 * 
 * @author junpuiou
 *
 */
public class IqiyiTokenUtils {

    private static Logger LOG = LogManager.getLogger(IqiyiTokenUtils.class);

    private static final Integer MODID = 1216;

    private static final Integer PARTNERID = 89201949;

    /**
     * getToken.
     * 
     */
    public static String getToken() {
        String src = MODID * PARTNERID + "i71";
        long t = System.currentTimeMillis();
        String secretkey = "i71" + t;
        String iv = 11717171 + "" + (MODID + 11717171);
        String token_0 = encrypt(src, secretkey, iv);
        String token = t + "" + token_0 + "_" + PARTNERID;
        return token;
    }

    /**
     * encrypt.
     */
    public static String encrypt(String src, String secretkey, String iv) {
        byte[] encrypted = null;
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(secretkey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivP = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivP);
            encrypted = cipher.doFinal(src.getBytes());
        } catch (Exception e) {
            LOG.error("加密串生成失败！", e);
            return null;
        }
        try {
            return URLEncoder.encode(new String(Base64.encodeBase64(encrypted)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("", e);
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getToken());
    }

}
