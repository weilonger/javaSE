package main.java.Utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 图片压缩并保存.
 */
public class ImgZipUtils {

    private static final String[] chars = new String[] {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /**
     * 缩放图片(压缩图片质量，改变图片尺寸)
     * 若原图宽度小于新宽度，则宽度不变！
     * @param originalFile 原图片路径地址
     * @param resizedFile 压缩后输出路径地址
     * @param maxWidth 最大宽度
     * @param maxHeight 最大高度
     * @param quality 图片质量参数 0.7f 相当于70%质量
     */
    public static void imageResize(File originalFile, File resizedFile, int maxWidth, int maxHeight, float quality) throws IOException {
        if (quality > 1) {
            throw new IllegalArgumentException(
                    "图片质量需设置在0.1-1范围");
        }

        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
        Image i = ii.getImage();
        Image resizedImage = null;

        int iWidth = i.getWidth(null);
        int iHeight = i.getHeight(null);

        int newWidth = maxWidth;
        if(iWidth < maxWidth){
            newWidth = iWidth;
        }

        if (iWidth < iHeight) {
            resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);
        }

        int newHeight = maxHeight;
        if(iHeight < maxHeight){
            newHeight = iHeight;
        }

        if(resizedImage==null && iHeight >= iWidth){
            resizedImage = i.getScaledInstance((newHeight * iWidth) / iHeight, newHeight, Image.SCALE_SMOOTH);
        }

        //此代码确保加载图像中的所有像素
        Image temp = new ImageIcon(resizedImage).getImage();

        //创建缓冲图像
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

        //将图像复制到缓冲图像
        Graphics g = bufferedImage.createGraphics();

        //清除背景并绘制图像。
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose();

        float softenFactor = 0.05f;
        float[] softenArray = { 0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);

        //将jpeg写入文件
        FileOutputStream out = new FileOutputStream(resizedFile);

        //将图像编码为jpeg数据流
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

        JPEGEncodeParam param = encoder
                .getDefaultJPEGEncodeParam(bufferedImage);

        param.setQuality(quality, true);

        encoder.setJPEGEncodeParam(param);
        encoder.encode(bufferedImage);
    }

    public static String getShortMD5(String source) {

        if (!StringUtils.isEmpty(source)) {

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] bs = md.digest(source.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(16);
                for (byte x : bs) {
                    sb.append(chars[(x & 0xff) % 32]);
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return getShortUUID();
    }

    public static String getShortUUID() {

        StringBuffer buffer = new StringBuffer();

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");

        for (int i = 0; i < 8; i++) {

            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            buffer.append(chars[x % chars.length]);
        }
        return buffer.toString();

    }

    public static void main(String[] args) throws Exception{
        //需要压缩的图片地址     aaa.jpg为需要压缩的图片
        String path = "c:Users/hwl/Pictures/电视剧图片/";
        String name = "U566D[G78UA6$MA]SU5(XVN.png";
        File customaryFile = new File(path + name);
        //压缩过后输出的路径地址    ddd.jpg 可进行设置为任意名称
        String newPath = "c:Users/hwl/Pictures/压缩后图片/";
        String newName = getShortMD5(name.split("\\.")[0]) + "." + name.split("\\.")[1];
        File compressAfter = new File(newPath + newName);

        imageResize(customaryFile,compressAfter,220,400,1);
    }
}
