package myleetjava.leetcodeStudy;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int one = 0, second = 0, lens = m + n, k = 0;
        double mid = 0, lastMid = 0;

        while (k < (m + n) / 2 + 1) {
            lastMid = mid;                  //把上一次的结果赋值给lastMid ,记录上一次的mid值
            /**
             让one++ 两种情况 ,
             1. nums1[one]<=nums2[second]
             2. second 数组遍历完毕
             反之 second++;
             */
            if (one < m && ((second >= n) || nums1[one] <= nums2[second])) {
                mid = nums1[one];
                one++;
            } else {
                mid = nums2[second];
                second++;
            }
            k++;
        }

        //判断len
        if (lens % 2 == 0) {
            //偶数
            return mid = (lastMid + mid) / 2.0;
        } else {
            return mid;
        }
    }
}
