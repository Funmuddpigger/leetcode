package myleetjava.sourcecodeleet;

public class searchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,7,8,9,15,18,70};
        int[] numNews = new int[nums.length+1];
        int target = 17;
        int i = 0;
        for (int num : nums){
            if(target==num){
                return ;
            }
            i++;
        }
        System.out.println("i is :" + i+"len is :" + nums.length);
        if(i>nums.length-1){
            i = 0;
            for(int num : nums){
                if(target<num){
                    System.out.println("< = "+ i); //i==2
                    for(int j=0;j<i;j++){
                        numNews[j]=nums[j];
                    }
                    numNews[i]=target;
                    System.out.println("in i is:"+i);
                    for(int j=i+1;j<=nums.length;j++){ //i==2;j==3;
                        numNews[j]=nums[i];
                        i++;
                    }
                    for (int t : numNews){
                        System.out.println("new: "+ t);

                    }
                    return ;
                }
                i++;
            }

        }


    }
}
