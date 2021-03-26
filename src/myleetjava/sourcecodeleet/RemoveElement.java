package myleetjava.sourcecodeleet;
//leetcode  27. 移除元素
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3},3));
    }

    public static int removeElement(int[] arr,int val){
        int len = arr.length;
        int right = len-1;
        boolean flag = false;
        if(len <1|| (len ==1 &&val != arr[0])){
            return len;
        }
        /**
         * left 找到相同的 ,right 从后面找不同的替换 ,换完之后,right 当前索引也是无效的,
         * 因为被删除了,当成无效的
         */
        for(int left = 0 ; left<len ;left++){
            if(arr[left]==val){
                flag = true;
                while(right>left&&arr[right]==val){
                    right--;
                }
                if(arr[right] != val){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }
        }
        if(!flag){
            return len;
        }
        return right;
    }
}
