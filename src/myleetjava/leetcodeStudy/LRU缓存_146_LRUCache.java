package leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU缓存_146_LRUCache {

    private Map<Integer,Integer> map;
    private int size;
    private List<Integer> list;

    public LRU缓存_146_LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(capacity);
        list = new ArrayList<>(capacity);
    }

    public int get(int key) {
        int i = list.indexOf(key);
        if(i == -1){
            return -1;
        }
        list.remove(i);
        list.add(0,key);
        return map.get(key);
    }

    public void put(int key, int value) {
        /**
         * 超出最小值,去掉,前提:
         *  1. map不存在该key,否则对应的val更新,不影响原来的size
         *  2. map.size大于指定的size
         */
        if(!map.containsKey(key)&&map.size()>size){
            //取出最后一个元素key(最久未用的元素)
            int x = list.get(list.size()-1);
            //对应的map,list中也移除
            list.remove(list.size()-1);
            map.remove(x);
        }
        //list已存在key,忽略
        int i = list.indexOf(key);
        if(i != -1){
            list.add(0,key);
        }else{
            //已存在,先移除,重新插入到最前面
            list.remove(i);
            list.add(0,key);
        }
        map.put(key,value);
    }

    public static void main(String[] args){
        LRU缓存_146_LRUCache lRUCache = new LRU缓存_146_LRUCache(2);

        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 3);    // 返回 1
        lRUCache.put(4, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(2);    // 返回 -1 (未找到)
    }
}
