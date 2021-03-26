package myleetjava.other;

public class LongAndFloat {

    public static void main(String[] args) {
        LongAndFloat x = new LongAndFloat();
        x.print(9);
        x.print(9.0f);
    }

    void print(long a){
        System.out.println("long"+a);
    }

    void print(float a){
        System.out.println("float"+a);
    }

}
