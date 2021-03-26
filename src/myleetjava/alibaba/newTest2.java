package myleetjava.alibaba;

import java.util.*;

import static javafx.scene.input.KeyCode.T;

public class newTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> listAck = new  ArrayList<>();
        List<Integer> listBlue = new  ArrayList<>();
        for(int i=0;i<n;i++){
            listAck.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            listBlue.add(sc.nextInt());
        }
        Integer[] arrAck = listAck.toArray(new Integer[listAck.size()]);
        Integer[] arrBlue = listBlue.toArray(new Integer[listBlue.size()]);
        System.out.println(getBlue(n,arrAck,arrBlue));
    }

    public static int getBlue(int n, Integer[] arrAck , Integer[] arrBlue){
        int sum = 0;
        int temp =Integer.MAX_VALUE;

        //      Map<Integer,Integer> hash = new HashMap<>();
//        for(int add =0;add<n;add++){
//            hash.put(arrAck[add],arrBlue[add]);
//        }
        for(int i=0; i<n ;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    sum = arrBlue[i]+arrBlue[j]+arrBlue[k];
                    temp = Math.min(temp,sum);
                }
            }
        }
        Arrays.sort(arrBlue);
        if(arrBlue[0] + arrBlue[1] + arrBlue[2]>=temp){
//            Integer one = hash.get(arrBlue[0]);
//            Integer two=hash.get(arrBlue[1]);
//            Integer three=hash.get(arrBlue[2]);
//            if(one<two&&two<three){
                return temp;
            }

        return -1;
    }
}
