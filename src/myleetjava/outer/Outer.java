package myleetjava.outer;


public class Outer {
    public String outer ="outer";
    private String outerPr = "outerPr";
    public void isOuter(){
        System.out.println(outer);
        System.out.println(outerPr);
        System.out.println(getInnerInstance().inner);
        getInnerInstance().isInner();
    }

    public Inner getInnerInstance(){
        return new Inner();
    }

    class Inner{
        public String inner ="inner";
        private String innerPr = "innerPr";
        public void isInner(){
            System.out.println(inner);
            System.out.println(outer);
            System.out.println(outerPr);
            isOuter();
        }
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        Inner in = out.new Inner();
        Outer.Inner in2 = out.new Inner();

        out.isOuter();
        in.isInner();

    }
}
