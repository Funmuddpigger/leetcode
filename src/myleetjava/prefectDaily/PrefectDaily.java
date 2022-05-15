package myleetjava.prefectDaily;

public class PrefectDaily {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(10);
        int count = 0;
        int length = s.length();
        for(int i = 0;i<length;i++){
            if('1'==s.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
