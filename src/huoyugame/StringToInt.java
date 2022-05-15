package huoyugame;

public class StringToInt {

    public static void main(String[] args) {
        System.out.println(StringInt("123"));
    }

    public static int StringInt(String str){
        int result = 0;
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i) ;
            int b = Character.getNumericValue(c);
            result = b + result*10;
        }
        return result;
    }
}
