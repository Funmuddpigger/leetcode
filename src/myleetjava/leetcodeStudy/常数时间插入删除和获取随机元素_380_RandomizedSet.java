package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/8/21 9:24
 */
public class 常数时间插入删除和获取随机元素_380_RandomizedSet {
    /**
     * 随机返回元素---数组，插入和删除---哈希表
     * 而且他们两个需要关联，当执行操作的时候
     * 插入：
     *   通过map.get得到元素查看是否null，是的话在进行插入，同时，key为插入值，value为插入数组的下标
     * 删除：
     *   通过map。get到元素查看是否null，是的话，则返回false，否则得到value，直接让被删除数等于数组最后一个的数，然后数组长度-1即可
     * 随机获取：
     *   通过随机数函数，从数组的长度范围内，随机读取
     */
    private static HashMap<Integer,Integer> map = new HashMap<>();

    private static ArrayList<Integer> list = new ArrayList<>();

    private static int size = 0;

    public 常数时间插入删除和获取随机元素_380_RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        //不存在，插入
        list.add(size,val);
        map.put(val,size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        //存在，删除,先从map取出下标
        Integer idx = map.get(val);
        //让当前等于最后一个
        Integer lastVal = list.get(size - 1);
        list.set(idx,lastVal);
        //修改map最后一个的对应
        map.put(lastVal,idx);
        list.remove(--size);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        if(size>1){
            int i = random.nextInt(size -1 );
            return list.get(i);
        }
        return list.get(0);
    }

}

