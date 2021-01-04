package myleetjava.outer;

public class OuterMethod {
    public String outer ="outer";
    private String outerPr = "outerPr";
    static int sss=111;
    //这是外部类的方法
    public void whatInner(){
        String outMethodMember = "局部变量";
        //定以局部内部类
        class MethodInner{
            int ss=111;
            //定以局部内部类的方法
            public void isInner(){
                System.out.println("Inner");
            }

        }
    }
}
