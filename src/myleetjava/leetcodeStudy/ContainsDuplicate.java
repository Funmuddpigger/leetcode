package myleetjava.leetcodeStudy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for(int x : nums){
                if(set.add(x)){
                    continue;
                }
                return true;
            }
            return false;
        }

}
