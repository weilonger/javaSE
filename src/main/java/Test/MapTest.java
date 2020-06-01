package main.java.Test;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;

public class MapTest {

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.test1();
    }

    private void test1() {
        // id, name
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "1111");
        map.put(2L, "2222");
        map.put(3L, "3333");

//        long[] ids = ArrayUtils.toPrimitive((Long[])map.keySet().toArray());
        long[] ids = ArrayUtils.toPrimitive(map.keySet().toArray(new Long[0]));
        for (long id : ids) {
            System.out.println(id);
        }
    }
}
