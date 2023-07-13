package myleetjava.leetcodeStudy;

import java.util.HashMap;

public class 赎金信_383_CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        //map映射,string 和 int ,int代表magazine出现的次数,当get为 null或者int中的value < 0 则false
        HashMap<Character, Integer> bitMap = new HashMap<>();
        char[] chars = magazine.toCharArray();
        char[] reChars = ransomNote.toCharArray();
        for(Character c : chars){
            if(bitMap.get(c)==null){
                bitMap.put(c,1);
            }else{
                bitMap.put(c,bitMap.get(c)+1);
            }
        }
        for(Character re : reChars){
                if(bitMap.get(re)!=null){
                    int res = bitMap.get(re) - 1;
                    if(res<0){
                        return false;
                    }
                    bitMap.put(re,res);
                }else {
                    return false;
                }
        }
        return  true;
    }
}
