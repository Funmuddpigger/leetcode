package util;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateCompletionUtil {

    /**
     * 获取当天任意某个时间段里的每个时间点 ---（传入开始的时间点和结束的时间点）
     * @param startTime 开始时间点
     * @param endTime 结束时间点
     * @return
     */
    public static List<String> getDayXAxis(int startTime, int endTime) {
        //一个小时一次的查询
        ArrayList<String> x = new ArrayList<>();
        for (int i = startTime; i <= endTime; i++) {
            x.add(i + "点") ;
        }
        return x;
    }

    /**
     * 取本周任意某个时间段（几天内）里的星期 ---（传入开始的星期和结束的星期）
     * @param startTime 开始周几
     * @param endTime   结束周几
     * @return
     */
    public static List<String> getWeekDayXAxis(Date startTime, Date endTime) {
        List<String> x = new ArrayList<>();
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        //计算开始时间是周几
        int w = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        c.setTime(endTime);
        int e = c.get(Calendar.DAY_OF_WEEK) - 1;
        //判断总长度,比他小，就是在前面,比他大则
        int len = e > w ? Math.abs(e - w) + 1 : weekDays.length - w + e + 1;
        while (len > 0) {
            x.add(weekDays[w]);
            w = (w + 1) % weekDays.length;
            len--;
        }
        return x;
    }

    /**
     * 获取每个时间
     * @param formatStr 日期展示格式
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    public static List<String> getDateXAxisData(String formatStr, LocalDateTime startDate, LocalDateTime endDate){
        //日期格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        ArrayList<String> x = new ArrayList<>();
        //遍历给定的日期期间的每一天
        for (int i = 0; !Duration.between(startDate.plusDays(i), endDate).isNegative(); i++) {
            //添加日期
            x.add(startDate.plusDays(i).format(formatter));
        }
        return x;
    }

    /**
     *  获取每个月份
     * @param formatStr 月份展示格式
     * @param startDate 开始月份
     * @param endDate 结束月份
     * @return
     */
    public static List<String> getMonthXAxisData(String formatStr, LocalDateTime startDate, LocalDateTime endDate){
        //日期格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        List<String> xAxis = new ArrayList<>();
        //遍历给定的日期期间的每一天
        for (int i = 0; !Duration.between(startDate.plusMonths(i), endDate).isNegative(); i++) {
            //添加日期
            xAxis.add(startDate.plusMonths(i).format(formatter));
        }
        return xAxis;
    }

    /**
     * 把key-value对象转map
     * @param list
     * @param t
     * @param keyFieldName
     * @param valueFieldName
     * @return
     * @param <T>
     */
    private <T> Map<String, T> getDateNumsMap(List<?> list, Class<T> t,String keyFieldName,String valueFieldName) {
        Map<String, T> map = new HashMap<>(16);
        list.forEach(f ->{
            try {
                Field at = f.getClass().getDeclaredField(keyFieldName);
                Field val = f.getClass().getDeclaredField(valueFieldName);
                map.put(at.toString(),  (T) val);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        });
        return map;
    }

    /**
     * 通过传入的时间列表和数据流，填充到对应的xy点位上
     * @param dateTimeList 完整的时间列
     * @param data 统计出来的数据集合
     * @param initVal 当map为空需要的默认值（0，null...）
     * @return
     * @param <T>
     */
    public <T> List<T> completionYAxisData(List<String> dateTimeList, Map<String,?> data, T initVal){
        ArrayList<T> dateList = new ArrayList<>(16);
        for(int i=0;i<dateTimeList.size();i++){
            if(data == null ||data.get(dateTimeList.get(i))==null){
                dateList.add(i,initVal);
            }
        }
        return dateList;
    }
}

/**
 * x轴y轴类，y轴可以传入具体的类型
 * @param <T>
 */
class TimeValChartVO<T> {

    List<String> xAxis;

    List<T> yAxis;

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    public List<T> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<T> yAxis) {
        this.yAxis = yAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeValChartVO<?> that = (TimeValChartVO<?>) o;
        return xAxis.equals(that.xAxis) && yAxis.equals(that.yAxis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis);
    }

    @Override
    public String toString() {
        return "TimeValChartVO{" +
                "xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                '}';
    }
}

