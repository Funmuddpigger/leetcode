package thread;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JpsAndJInfo {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        List<String> strings = completionDate(now, now.plusDays(10),"yyyy-MM-dd",1);
        strings.forEach(System.out::println);
    }

    public static List<String> completionDate(
            LocalDateTime startDate,
            LocalDateTime endDate,String formatStr,int timeType) {
        //日期格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        List<String> dateList = new ArrayList<>();
        if (timeType==0){
            //遍历给定的日期期间的每一天
            for (int i = 0; !Duration.between(startDate.plusHours(i), endDate).isNegative(); i++) {
                //添加日期
                dateList.add(startDate.plusHours(i).format(formatter));
            }
        } else if (timeType==1){
            //遍历给定的日期期间的每一天
            for (int i = 0; !Duration.between(startDate.plusDays(i), endDate).isNegative(); i++) {
                //添加日期
                dateList.add(startDate.plusDays(i).format(formatter));
            }
        }

        return dateList;
    }

}
