package proxy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/12 16:01
 */
public class MyInitOp implements MyInitOpInterface{

    public MyInitOp(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String sendRequest() {
        return "OK";
    }
}
