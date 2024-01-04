package proxy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/12 16:12
 */
public class TestMain {

    public static void main(String[] args) {
        MyInitOp proxy = new MyInitOp();
        proxy.sendRequest();
        MyInitOp myInitOpProxy = new MyInitOp();
        myInitOpProxy.sendRequest();
    }

}
