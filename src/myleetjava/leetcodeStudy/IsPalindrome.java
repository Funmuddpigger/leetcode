package myleetjava.leetcodeStudy;

//leetcode 125.验证回文串
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a."));
    }

    /**
     * 双指针,原数组上进行遍历,某一指针 能安全走到底证明他全部相同没有跳出
     */
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0,right = len-1;
        if(len<=1){
            return true;
        }
        while(left<=len-1&&right>=0){
            if(!Character.isLetterOrDigit(chars[left])){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(chars[right])){
                right--;
                continue;
            }
            if(!String.valueOf(s.charAt(left)).equalsIgnoreCase(String.valueOf(s.charAt(right)))){
                break;
            }
            left++;right--;
        }
        if(left==len||right==-1){
            return true;
        }
        return false;
    }

    /**
     * 双指针,通过遍历字符串全部转换小写,放到新的字符串中,然后开始双指针遍历,如果没有跳出则证明相同
     */
    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
