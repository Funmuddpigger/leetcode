package myleetjava.sourcecodeleet;

import java.util.Arrays;

public class findContentChildren {

    public static void main(String[] args) {
        System.out.println(findContentChildrenChange(new int[] {10,9,8,7},new int[] {5,6,7,8}));
    }

    public static int findContentChildren(int[] g, int[] s){
        //贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
        Arrays.sort(g);
        Arrays.sort(s);
        int childs = g.length;
        int bings = s.length;
        int count=0;
        for(int i=0,j=0;i<childs&&j<bings;i++,j++){
            while(j<bings&&g[i]>s[j]){
                j++;
                System.out.println(j);
            }
            if(j<bings){
                count++;
            }
        }
        return count;
    }

    public static int findContentChildrenChange(int[] g, int[] s){
        //贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
        Arrays.sort(g);
        Arrays.sort(s);
        int childs =0;
        int bings =0;
        while(childs<g.length&&bings<s.length){
            if(g[childs]<=s[bings]){
                childs++;
            }
            bings++;
        }
        return childs;
    }
}
