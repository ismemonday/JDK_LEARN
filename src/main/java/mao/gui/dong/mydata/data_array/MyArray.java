package mao.gui.dong.mydata.data_array;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyArray {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        objectObjectTreeMap.put(1, 1);

    }

    private static void arrList() {
        ArrayList<Object> arrs = new ArrayList<>();

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        System.out.println(myArrayList.size());

    }
}
