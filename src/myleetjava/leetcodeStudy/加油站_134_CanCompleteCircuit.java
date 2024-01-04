package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/7 16:15
 */
public class 加油站_134_CanCompleteCircuit {

    public static void main(String[] args) {
//        System.out.println(canCompleteCircuitMath(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuitMath(new int[]{2,3,4},new int[]{3,4,3}));
//        System.out.println(canCompleteCircuit(new int[]{5},new int[]{4}));
    }

    /**
     * 由于只要求走完一圈，并没有要求需要最优解，而且题目保证了如有解，必定是唯一解。
     * 所以我们只需要通过遍历。
     *     1. 从头开始遍历，如果可以走到下一个油站（gas[i] + restGas > cost[i]）则继续遍历直到回到初始点
     *     2. 否则跳过，从下一个油站，point = gas[i+1]
     *     3. 中途遇到断开的从gas[i+1]开始
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //从第一个油站开始
        for (int i = 0; i < gas.length; i++) {
            int restGas = 0;
            //计算是否足够驶过第一个油站
            if(gas[i] < cost[i]) continue;
            restGas += (gas[i] - cost[i]);
            int tmp = i+1 >= cost.length ? 0 : i+1;
            for (int j = tmp; j != i; ) {
                //计算从i油站走到下一个油站j剩余的油
                restGas += (gas[j] - cost[j]);
                if(restGas<0) break;
                //进入到下一个油站
                j = j+1 < cost.length? j+1 : 0;
                //当前到达油站 j值取出
                tmp = j;
            }
            if(i == tmp) return i;
        }
        return -1;
    }

    /**
     * 由于只要求走完一圈，并没有要求需要最优解，而且题目保证了如有解，必定是唯一解。
     * 所以我们只需要通过遍历。
     *     1. 从头开始遍历，如果可以走到下一个油站（gas[i] + restGas > cost[i]）则继续遍历直到回到初始点
     *     2. 否则跳过，从下一个油站，point = gas[i+1]
     *     3. 中途遇到断开,设断开位置为y，从gas[y+1]开始（也就是跳过i到y之间的所有点位）
     *
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuitMath(int[] gas, int[] cost) {
        //从第一个油站开始
        for (int i = 0; i < gas.length; ) {
            int restGas = 0;
            //计算是否足够驶过第一个油站
            if(gas[i] < cost[i]) {
                i++;
                continue;
            }
            restGas += (gas[i] - cost[i]);
            int tmp = i+1 >= cost.length ? 0 : i+1;
            for (int j = tmp; j != i; ) {
                //计算从i油站走到下一个油站j剩余的油
                restGas += (gas[j] - cost[j]);
                if(restGas<0) break;
                //进入到下一个油站
                j = j+1 < cost.length? j+1 : 0;
                //当前到达油站 j值取出
                tmp = j;
            }
            if(i == tmp) return i;
            else i=tmp > i ? tmp+1: gas.length;
        }
        return -1;
    }
}
