package main.java.Test;
import org.apache.hadoop.hbase.util.Bytes;

public class BytesTest {
    private static final byte[] FAMILY = Bytes.toBytes("q_m");
    public static void main(String[] args) {

        for (byte f : FAMILY) {
            System.out.println(f);
        }
    }
}
