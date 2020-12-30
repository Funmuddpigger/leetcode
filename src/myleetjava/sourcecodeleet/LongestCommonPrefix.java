package myleetjava.sourcecodeleet;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"","","dfg"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int len0 = strs[0].length();
        int count = strs.length;
        int strLen = 0;
        for1:
        for (int i = 0; i < len0; i++) {
            char c = strs[0].charAt(i);
            for2:
            for (int j = 1; j < count; j++) {
                if(i>strs[j].length()-1||strs[j].charAt(i)!=c){
                    break for1;
                }
            }
            strLen++;
        }
        return strs[0].substring(0,strLen);
    }
}
