package myleetjava.pro.code;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalLong;

public class test {
    public static void main(String[] args) {
        StringBuilder bu = new StringBuilder("地市");
        bu.append("中心暂停事件关系.操作人: ").append("我");
       // bu.replace(0,2,"省");
        Long lo= null;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2037,11,31,0,0,0);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String expDate = simpleDateFormat.format(date);

        Long aLong = Optional.ofNullable(lo).orElseGet(() -> getVoid());

        System.out.println(lo);
    }

    public static Long getVoid(){
        return 1L;
    }

}
