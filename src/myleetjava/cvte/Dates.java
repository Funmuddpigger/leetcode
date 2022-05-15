package myleetjava.cvte;
import java .util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Dates {

    public static void main(String[] args) {

    }

    public static String noticeTime(String deadline,String time,String[] starts) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date deadDate = format.parse(deadline);
        Date timeDate = format.parse(time);
        long deadTime = deadDate.getTime();
        long timeTime = timeDate.getTime();
        long res = deadTime - timeTime;
        for(String str : starts) {
            Date parse = format.parse(str);
            long startTime = parse.getTime();
            if(res > startTime){
                System.out.print(str);
                return str;
            }
        }
        return null;
    }
}
