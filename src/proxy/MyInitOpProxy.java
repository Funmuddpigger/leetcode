package proxy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/12 16:05
 */
public class MyInitOpProxy implements MyInitOpInterface{
    private static MyInitOp init = null;


    @Override
    public String sendRequest() {
        if(init==null){
            init = new MyInitOp();
        }
        return init.sendRequest();
    }
}

