package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/4/15 15:20
 */
public class 设计哈希映射_706_MyHashMap {

    private ArrayList<Integer> keyList;
    private ArrayList<Integer> valueList;

    private int idx;

    public 设计哈希映射_706_MyHashMap() {
        keyList = new ArrayList<>(16);
        valueList = new ArrayList<>(16);
        idx = 0;
    }

    public void put(int key, int value) {
        keyList.add(key);
        valueList.add(key,value);
    }

    public int get(int key) {
        return valueList.get(key);
    }

    public void remove(int key) {
        valueList.remove(key);
    }

}
