package myleetjava.leetcodeStudy;

public class 找出字符串中第一个匹配项的下标__28_StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        int haLen = haystack.length(), neLen = needle.length();
        if (neLen == 0) {
            return 0;
        }

        int haLeft = 0, neLeft = 0;
        while (haLeft < haLen && neLeft < neLen) {
            if (haystack.charAt(haLeft) == (needle.charAt(neLeft))) {
                haLeft++;
                neLeft++;
            } else {
                haLeft = haLeft - neLeft + 1;
                neLeft = 0;
            }
            if (neLeft == neLen) {
                return haLeft - neLeft;
            }
        }
        return -1;
    }
}
