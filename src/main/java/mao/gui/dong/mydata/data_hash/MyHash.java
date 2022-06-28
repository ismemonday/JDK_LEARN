package mao.gui.dong.mydata.data_hash;

import java.util.HashMap;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/5/6 下午3:03
 */
public class MyHash {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<Object, Object>(4);
        Integer i = Integer.valueOf(6);
        Long l = Long.valueOf(6);
        Short s = Short.valueOf((short) 6);
        Byte b = Byte.valueOf((byte) 6);
        System.out.println(i.hashCode());
        System.out.println(l.hashCode());
        System.out.println(s.hashCode());
        System.out.println(b.hashCode());
        objectObjectHashMap.put(i, 1);
        objectObjectHashMap.put(l, 2);
        objectObjectHashMap.put(s, 3);
        objectObjectHashMap.put(b, 4);
    }

}
